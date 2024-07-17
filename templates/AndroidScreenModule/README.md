### Импорт Screen Module для Android

В папке **Android Screen Module** располагается шаблон для модуля под Android Screen, для того, чтобы его установить нужно сделать пару простых шагов:

1. Убрать у файла _**build.gradle.kts.wt**_ расширение _**.wt**_   
2. Скопировать папку _**screen**_ из **Android Screen Module** и переместить её в папку androidApp/features/screen/
3. Переименовать 3 папки:
   1. Скопированную папку screen и _screen (src/main/java/com/***/screen/_screen) на название вашего модуля 
   2. Изменить название папки (src/main/java/com/***) на название вашего проекта 
4. В build gradle изменить также название модуля и добавить модуль View Model, если он есть в shared/features/***
5. Добавить в settings.gradle путь к вашему модулю. Пример:
~~~kotlin
include(":androidApp:features:screen:*название_модуля*")
~~~

### Импорт Screen View Model для Shared
1. Убрать у файла _**build.gradle.kts.wt**_ расширение _**.wt**_
2. Скопировать папку **_Screen View Model_** из **Android Screen Module** и переместить её в папку shared/features/
3. Переименовать 3 папки:
   1. Скопированную папку screenViewModel и _screen (src/commonMain/kotlin/com/***/features/_screen) на название вашего модуля
   2. Изменить название папки (src/commonMain/kotlin/com/***/) на название вашего проекта
4. В build gradle изменить также название модуля
5. Добавить в settings.gradle путь к вашему модулю. Пример:
~~~kotlin
include(":shared:features:*название_модуля*")
~~~

Также если есть di, то необходимо его добавить в shared/features/root/initKoin.kt