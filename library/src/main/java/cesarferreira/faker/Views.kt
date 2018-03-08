package cesarferreira.faker

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.squareup.picasso.Picasso

private val defaultPlaceholder = R.color.defaultPlaceholder
private val defaultError = R.color.errorPlaceholder

fun ImageView.loadFromUrl(url: String, placeholder: Int = defaultPlaceholder, error: Int = defaultError, callback: OnImageLoadListener? = null) =
        loadImage(
                context = this.context.applicationContext,
                imageView = this,
                url = url,
                placeholder = placeholder,
                error = error,
                callback = callback
        )

fun ImageView.loadRandomImage(callback: OnImageLoadListener? = null) {
    this.post({
        loadImage(
                context = this.context.applicationContext,
                imageView = this,
                url = Faker.getRandomImage(this.measuredWidth, this.measuredHeight),
                placeholder = defaultPlaceholder,
                error = defaultError,
                callback = callback
        )
    })
}

fun ImageView.loadRandomImage(width: Int, height: Int, callback: OnImageLoadListener? = null) =
        loadImage(
                context = this.context.applicationContext,
                imageView = this,
                url = Faker.getRandomImage(width, height),
                placeholder = defaultPlaceholder,
                error = defaultError,
                callback = callback
        )

fun loadImage(context: Context, imageView: ImageView, url: String, placeholder: Int, error: Int, callback: OnImageLoadListener?) =
        Picasso.with(context)
                .load(url)
                .placeholder(placeholder)
                .error(error)
                .into(imageView, callback)

private fun loadImage(context: Context, imageView: ImageView, url: String, placeholder: Drawable, error: Drawable) {
    Picasso.with(context)
            .load(url)
            .placeholder(placeholder)
            .error(error)
            .into(imageView)
}
