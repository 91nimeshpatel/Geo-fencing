# GeoFencing App Demo

This is a simple GeoFencing app demo that supports Android 10 and above. The app uses Hilt for dependency injection and displays notifications for different geofence transitions. It also uses the default Android Splash API for the splash screen and Google Maps API for geo-fencing.

## Permissions

The app requires the following permissions:

```xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_BACKGROUND_LOCATION" />
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
 ```

## Gradle Properties

### Namespace

The namespace used in the project is `com.nimeshpatel.geofencing`.

### Compile SDK Version

The `compileSdk` version used in the project is `34`.

### Default Configuration

The default configuration settings in the `build.gradle` file are as follows:

- **Application ID**: `com.nimeshpatel.geofencing`
- **Minimum SDK Version**: `24`
- **Target SDK Version**: `34`
- **Gradle Version**: `8.6`
- **Android Gradle Plugin (AGP) Version**: `8.3.2`

The `api_key` used in the project is provided as a resource value.



## Features

- **Geofence Transitions**: The app handles three geofence transitions:
  - Enter
  - Dwell
  - Exit

- **Notifications**: The app shows notifications for each of the geofence transitions using a broadcast receiver.

- **Dependency Injection**: The app uses Hilt to easily inject the ViewModel.

- **Splash Screen**: The app uses the default Android Splash API for the splash screen.

- **Google Maps Integration**: The app integrates Google Maps API for geo-fencing.

## Setup

1. **Clone the Repository**: Clone the repository to your local machine.

   ```sh
   git clone <repository_url>
   ```
2. **Open the Project:**: Open the project in Android Studio.
3. **Add Google Maps API Key:**: Add your Google Maps API key in the **AndroidManifest.xml** file.
  ```xml
  <meta-data
      android:name="com.google.android.geo.API_KEY"
      android:value="YOUR_API_KEY" />
   ```
  4. **Add Broadcast Receiver:** Add the following receiver configuration to your **AndroidManifest.xml** file.
  ```xml
  <receiver
      android:name=".util.receiver.GeofenceBroadcastReceiver"
      android:enabled="true"
      android:exported="true">
      <intent-filter>
          <action android:name="com.google.android.gms.location.Geofence" />
      </intent-filter>
  </receiver>
  ```
5. **Run the App:** Run the app on an Android device or emulator.

