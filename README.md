Jugoterapia Appium
----------------------------

[Appium](http://appium.io/) is an open-source tool for automating native, mobile web, and hybrid applications on both iOS and Android. Appium supports app automation across a variety of platforms, like iOS, Android, and Windows. Each platform is supported by one or more “drivers”, which know how to automate that particular platform.

#### To Build Environments

```bash
gradle -Pjtpenv=local -b environments.gradle settingEnvironment
```

where:

* `local` To run in emulator or real device locally
* `saucelabs-emulator` To run in [SauceLabs](https://saucelabs.com/) emulator devices
* `saucelabs-real` To run in [SauceLabs](https://saucelabs.com/) real devices

#### Seting Environment

* `export jtpenv=local`
* `echo $jtpenv`

#### To Set Credentials

```bash
gradle -Puser=josdem -Papi=api -Pkey=key -b credentials.gradle settingCredentials
```

where:

* `user` Is your [SauceLabs](https://saucelabs.com/) username
* `api` Is your [SauceLabs](https://saucelabs.com/) API
* `key` Is your [SauceLabs](https://saucelabs.com/) key

#### To run the project

```bash
gradle testDebug
```

#### Read this as reference

* http://josdem.io/techtalk/android/appium_automation
* http://josdem.io/techtalk/android/appium_cucumber_junit5/

**Note:** This project uses [Jugoterapia](https://play.google.com/store/apps/details?id=com.jugoterapia.josdem) project as an Android application for testing, know more about this project here:

* http://josdem.io/jugoterapia/jugoterapia/
