# ShoesStoreApplication

Учебный интерфейс магазина обуви на Kotlin и Jetpack Compose. Включает вход, главный экран с карточками товаров и избранное; локальное состояние входа хранится через SharedPreferences.

## Сборка и запуск

Откройте корень проекта в Android Studio, установите Android SDK 35 и выполните синхронизацию Gradle. Используйте JDK, совместимый с версией Android Gradle Plugin проекта; настройки Java указаны в `app/build.gradle.kts`. Минимальная версия устройства — Android API 24.

Для сборки отладочного APK:

```sh
sh gradlew :app:assembleDebug
```

В Windows: `gradlew.bat :app:assembleDebug`. APK появится в `app/build/outputs/apk/debug/`. Для запуска выберите модуль `app` и устройство или эмулятор в Android Studio.

## Устройство проекта

Экраны находятся в `app/src/main/java/com/example/snoesstoreapplication/presentation/screen/`, модель товара — в `data/models/UIProduct.kt`. Проект демонстрирует клиентский интерфейс, а не полный сервис оформления и оплаты заказов.
