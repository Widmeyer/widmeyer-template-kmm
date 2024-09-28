#!/bin/bash

SOURCE_FILE="shared/resources/src/commonMain/moko-resources/colors/colors.xml"
TARGET_FILE="androidApp/ui/src/main/res/values/colors.xml"
COLORS_KT_FILE="androidApp/ui/src/main/java/com/widmeyertemplate/ui/Colors.kt"

BUILD_DIR="shared/resources/build"

copy_colors_file() {
  cp "$SOURCE_FILE" "$TARGET_FILE"
  if [ $? -eq 0 ]; then
    echo "Файл $SOURCE_FILE успешно скопирован в $TARGET_FILE"
  else
    echo "Ошибка при копировании $SOURCE_FILE в $TARGET_FILE"
  fi
}

update_colors_kt() {
  NEW_COLOR_NAME=$(grep -o 'name="[^"]*"' "$SOURCE_FILE" | sed 's/name="\([^"]*\)"/\1/' | tail -n 1)

  if grep -q "val $NEW_COLOR_NAME:" "$COLORS_KT_FILE"; then
    echo "Цвет $NEW_COLOR_NAME уже существует в $COLORS_KT_FILE"
    return
  fi

  sed -i '' "/abstract val transparent: Color/a\\
    abstract val $NEW_COLOR_NAME: Color
  " "$COLORS_KT_FILE"

  sed -i '' "/override val transparent: Color = Color.Transparent,/a\\
        override val $NEW_COLOR_NAME: Color = Color(MultiplatformResource.colors.$NEW_COLOR_NAME.getColor(context)),
  " "$COLORS_KT_FILE"

  if [ $? -eq 0 ]; then
    echo "Цвет $NEW_COLOR_NAME успешно добавлен в $COLORS_KT_FILE"
  else
    echo "Ошибка при добавлении цвета в $COLORS_KT_FILE"
  fi
}

clean_build() {
  echo "Удаление папки build..."
  rm -rf "$BUILD_DIR"
  if [ $? -eq 0 ]; then
    echo "Папка build успешно удалена."
  else
    echo "Ошибка при удалении папки build."
  fi
}

rebuild_module() {
  echo "Пересборка модуля resource..."
  (./gradlew :shared:resources:build)
  if [ $? -eq 0 ]; then
    echo "Модуль resource успешно пересобран."
  else
    echo "Ошибка при пересборке модуля resource."
  fi
}

fswatch -o "$SOURCE_FILE" | while read; do
  echo "Файл $SOURCE_FILE изменён. Выполняется обновление..."
  copy_colors_file
  clean_build
  rebuild_module
  update_colors_kt
done

