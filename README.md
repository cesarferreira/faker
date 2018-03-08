<div align="center"><img src="extras/ss9.png" /></div>

# <div align="center">Faker</div>

<div align="center">A <b>kotlin extension</b> to <b>load images asynchronously</b> on <b>android</b></div><br>

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
	<a href="https://jitpack.io/#cesarferreira/faker">
    <img src="https://jitpack.io/v/cesarferreira/faker.svg"
      alt="License: MIT" />
  </a>
</div><br>

# Features

- Load random images asynchronously into any `ImageView`
- Will download a random image that fits perfectly the size of that `imageView`
- Load any image by passing a simple url into it
- Perfect for image placeholders

# Usage
Just add the following dependency in your app's `build.gradle`

```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

dependencies {
      implementation 'com.github.cesarferreira:faker:1.0.0'
}
```

<!-- implementation 'com.github.cesarferreira.faker:library:1.0.0' -->

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