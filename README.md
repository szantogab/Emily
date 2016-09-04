# Emily
An easy-to-use wrapper library for SharedPreferences on Android.

This library has been developed in order to eliminate the cumbersome boilerplate that Android developers need to write when using the SharedPreferences Android API.
I got tired of copy-pasting all the time.

## Features
  - Write an interface with objects that you want to save with SharedPrefs, and Emily will generate the implementation for you.
  - You can save SharedPref primitives (int, float, long, String), and you can also save custom objects that will be serialized and deserialized automatically.
  - Works really nicely with dependency injection and Dagger 2, so you get easily testable code.
  - It generates the code with annotation processing, so it is really fast, because no reflection is used.
  - The serialized custom objects can be cached (enabled by default), so no blocking when setting or getting an object.
  - If you want, you can define custom Serializer classes to specify how exactly the custom objects' serialization works. By default Emily provides two Serializer implementations (Gson and built-in Java serialization mechanism).

## Import the library from jCenter
First, add this to your top-level build.gradle:
```gradle
classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
```

In your app-level build.gradle, apply the plugin at the top:
```gradle
apply plugin: 'com.neenbedankt.android-apt'
```

Then you can import this library and use the annotation processor:
```gradle
repositories {
    maven { url 'https://dl.bintray.com/szantogab/maven' }
}

compile 'com.appsquare.emily:api:1.0.0'
apt 'com.appsquare.emily:compiler:1.0.0'
```

## Usage

First, create an interface where you define the methods and objects you want to save in SharedPref. **Important: you have to follow the getXyz() and setXyz() code style.**
```java
@emily.LocalStorage(cached = true)
public interface LocalStorage {
    // Save the user who logged in to the application
    User getUser();
    void setUser(User user);
    
    // For example a token that you received from a REST server
    String getToken();
    void setToken(String token);
    
    // If you want to specify the name of the key in SharedPref, you can do this:
    @Named("some_host")
    String getHost();
    @Named("some_host")
    void setHost(String host);    
}
```

After you compile your project, an EmilyLocalStorage (Emily + the name of the interface you defined) class will be generated, so usage is as follows:

```java
...

LocalStorage localStorage = new EmilyLocalStorage(context, "SharedPrefName", new GsonSerializer(gson));
        
// Set the user
localStorage.setUser(new User("First Name", "Last Name"));

// Get the user
User user = localStorage.getUser();

...
```

## Contributions
Please feel free to submit and fix bugs (if you find any), or even make a pull request to Emily. :)

## Author
Gabor Szanto, 2016

