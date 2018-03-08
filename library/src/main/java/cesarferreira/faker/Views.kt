package cesarferreira.faker

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.squareup.picasso.Picasso

private val defaultPlaceholder = R.color.defaultPlaceholder
private val defaultError = R.color.errorPlaceholder

fun ImageView.loadFromUrl(url: String) =
        loadImage(
                context = this.context.applicationContext,
                imageView = this,
                url = url,
                placeholder = defaultPlaceholder,
                error = defaultError
        )

fun ImageView.loadFromUrl(url: String, placeholder: Int, error: Int) =
        loadImage(
                context = this.context.applicationContext,
                imageView = this,
                url = url,
                placeholder = placeholder,
                error = error
        )

fun ImageView.loadFromUrl(url: String, placeholder: Drawable, error: Drawable) =
        loadImage(
                context = this.context.applicationContext,
                imageView = this,
                url = url,
                placeholder = placeholder,
                error = error
        )

fun ImageView.loadRandomImage() {
    this.post({
        loadImage(
                context = this.context.applicationContext,
                imageView = this,
                url = getRandomImage(this.measuredWidth, this.measuredHeight),
                placeholder = defaultPlaceholder,
                error = defaultError
        )
    })
}

fun ImageView.loadRandomImage(width: Int, height: Int) =
        loadImage(
                context = this.context.applicationContext,
                imageView = this,
                url = getRandomImage(width, height),
                placeholder = defaultPlaceholder,
                error = defaultError
        )


private fun loadImage(context: Context, imageView: ImageView, url: String, placeholder: Int, error: Int) {
    Picasso.with(context)
            .load(url)
            .placeholder(placeholder)
            .error(error)
            .into(imageView)
}

private fun loadImage(context: Context, imageView: ImageView, url: String, placeholder: Drawable, error: Drawable) {
    Picasso.with(context)
            .load(url)
            .placeholder(placeholder)
            .error(error)
            .into(imageView)
}

private fun valueWithSalt(value: Int) = value + (0..20).random()
private fun getRandomImage(width: Int, height: Int) = "https://picsum.photos/${valueWithSalt(width)}/${valueWithSalt(height)}"
