#!/bin/bash

SOURCE_FILE="shared/resources/src/commonMain/moko-resources/base/strings.xml"
TARGET_PATHS=(
  "shared/resources/src/commonMain/moko-resources/en/strings.xml"
  "shared/resources/src/commonMain/moko-resources/ru/strings.xml"
  "androidApp/ui/src/main/res/values/strings.xml"
)

BUILD_DIR="shared/resources/build"

copy_file() {
  for TARGET_FILE in "${TARGET_PATHS[@]}"; do
    cp "$SOURCE_FILE" "$TARGET_FILE"
    if [ $? -eq 0 ]; then
      echo "Файл успешно скопирован в $TARGET_FILE"
    else
      echo "Ошибка при копировании в $TARGET_FILE"
    fi
  done
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
  echo "Файл $SOURCE_FILE изменён. Выполняется копирование..."
  copy_file
  clean_build
  rebuild_module
done
