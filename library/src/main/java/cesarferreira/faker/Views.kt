package cesarferreira.faker

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

private val DEFAULT_PLACEHOLDER = R.color.defaultPlaceholder
private val DEFAULT_ERROR = R.color.errorPlaceholder
private val DEFAULT_CALLBACK = object : OnImageLoadListener {
    override fun onSuccess() { /* noop */
    }

    override fun onError() { /* noop */
    }
}

fun ImageView.loadFromUrl(url: String,
                          placeholder: Int = DEFAULT_PLACEHOLDER,
                          error: Int = DEFAULT_ERROR,
                          callback: OnImageLoadListener = DEFAULT_CALLBACK) =
        loadImage(
                context = this.context.applicationContext,
                imageView = this,
                url = url,
                placeholder = placeholder,
                error = error,
                callback = callback
        )

fun ImageView.loadFromUrl(url: String,
                          placeholder: Drawable,
                          error: Drawable, callback:
                          OnImageLoadListener = DEFAULT_CALLBACK) =
        loadImage(
                context = this.context.applicationContext,
                imageView = this,
                url = url,
                placeholder = placeholder,
                error = error,
                callback = callback
        )

fun ImageView.loadRandomImage(callback: OnImageLoadListener = DEFAULT_CALLBACK) {
    this.post({
        loadImage(
                context = this.context.applicationContext,
                imageView = this,
                url = Faker.getRandomImage(this.measuredWidth, this.measuredHeight),
                placeholder = DEFAULT_PLACEHOLDER,
                error = DEFAULT_ERROR,
                callback = callback
        )
    })
}

fun ImageView.loadRandomImage(width: Int,
                              height: Int,
                              callback: OnImageLoadListener = DEFAULT_CALLBACK) =
        loadImage(
                context = this.context.applicationContext,
                imageView = this,
                url = Faker.getRandomImage(width, height),
                placeholder = DEFAULT_PLACEHOLDER,
                error = DEFAULT_ERROR,
                callback = callback
        )

private fun loadImage(context: Context,
                      imageView: ImageView,
                      url: String,
                      placeholder: Drawable,
                      error: Drawable,
                      callback: OnImageLoadListener) {
    Picasso.with(context)
            .load(url)
            .placeholder(placeholder)
            .error(error)
            .into(imageView, object : Callback {
                override fun onSuccess() {
                    callback.onSuccess()
                }

                override fun onError() {
                    callback.onError()
                }
            })
}

private fun loadImage(context: Context,
                      imageView: ImageView,
                      url: String,
                      placeholder: Int,
                      error: Int,
                      callback: OnImageLoadListener) {
    Picasso.with(context)
            .load(url)
            .placeholder(placeholder)
            .error(error)
            .into(imageView, object : Callback {
                override fun onSuccess() {
                    callback.onSuccess()
                }

                override fun onError() {
                    callback.onError()
                }
            })
}