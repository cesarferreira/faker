package cesarferreira.faker

import android.graphics.drawable.Drawable
import android.widget.ImageView

private val DEFAULT_PLACEHOLDER = R.color.defaultPlaceholder
private val DEFAULT_ERROR = R.color.errorPlaceholder

class Views {}

fun ImageView.loadFromUrl(url: String,
                          placeholder: Int = DEFAULT_PLACEHOLDER,
                          error: Int = DEFAULT_ERROR) =
        loadImage(
                imageView = this,
                url = url,
                placeholder = placeholder,
                error = error
        )

fun ImageView.loadFromUrl(url: String,
                          placeholder: Drawable,
                          error: Drawable) =
        loadImage(
                imageView = this,
                url = url,
                placeholder = placeholder,
                error = error
        )

fun ImageView.loadRandomImage() {
    this.post({
        loadImage(
                imageView = this,
                url = Faker.getRandomImage(this.measuredWidth, this.measuredHeight),
                placeholder = DEFAULT_PLACEHOLDER,
                error = DEFAULT_ERROR
        )
    })
}

fun ImageView.loadRandomImage(width: Int,
                              height: Int) =
        loadImage(
                imageView = this,
                url = Faker.getRandomImage(width, height),
                placeholder = DEFAULT_PLACEHOLDER,
                error = DEFAULT_ERROR
        )

private fun loadImage(imageView: ImageView,
                      url: String,
                      placeholder: Drawable,
                      error: Drawable) {

    GlideApp.with(imageView.context)
            .load(url)
            .placeholder(placeholder)
            .error(error)
            .into(imageView)
}

private fun loadImage(imageView: ImageView,
                      url: String,
                      placeholder: Int,
                      error: Int) {

    GlideApp.with(imageView.context)
            .load(url)
            .placeholder(placeholder)
            .error(error)
            .into(imageView)
}