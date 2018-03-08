<div align="center"><img src="extras/ss4.png" height="300" /></div>

# <div align="center">Faker</div>

<div align="center">A kotlin extension to load images asynchronously on android</div><br>

<div align="center">
	<a href="https://www.android.com">
    <img src="https://img.shields.io/badge/platform-Android-brightgreen.svg?style=flat-square"
      alt="Platform" />
  </a>
	<a href="https://android-arsenal.com/api?level=16">
    <img src="https://img.shields.io/badge/API-16%2B-blue.svg?style=flat-square"
      alt="API" />
  </a>
	<a href="https://opensource.org/licenses/MIT">
    <img src="https://img.shields.io/badge/License-MIT-red.svg?style=flat-square"
      alt="License: MIT" />
  </a>
</div><br>

# Features

- Load random images asynchronously into any `ImageView`
- Load any image by passing a simple url into it

# Usage
Just add the following dependency in your app's `build.gradle`

```groovy
dependencies {
      compile 'cesarferreira.faker:library:1.0.0'
}
```

# Examples
Here are some examples to provide you a head start with using this library.

<b>`.loadRandomImage()`</b>

```kotlin
imageView.loadRandomImage()
```

<b>`.loadFromUrl(url: String)`</b>

```kotlin
imageView.loadFromUrl("http://sample.com/image.png")
```

<b>`.loadFromUrl(url: String, placeholder: Int, error: Int)`</b>

```kotlin
imageView.loadFromUrl("http://sample.com/image.png", R.color.placeholder, R.color.error)
```


# License
Licensed under `MIT license`. View [license](LICENSE.md).