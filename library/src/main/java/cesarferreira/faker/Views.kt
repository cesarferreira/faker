package cesarferreira.faker

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

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
                imageView = this,
                url = url,
                placeholder = placeholder,
                error = error,
                callback = callback
        )

fun ImageView.loadRandomImage(callback: OnImageLoadListener = DEFAULT_CALLBACK) {
    this.post({
        loadImage(
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
                imageView = this,
                url = Faker.getRandomImage(width, height),
                placeholder = DEFAULT_PLACEHOLDER,
                error = DEFAULT_ERROR,
                callback = callback
        )

private fun loadImage(imageView: ImageView,
                      url: String,
                      placeholder: Drawable,
                      error: Drawable,
                      callback: OnImageLoadListener) {
    Picasso.get()
            .load(url)
            .placeholder(placeholder)
            .error(error)
            .into(imageView, object : Callback {
                override fun onError(e: Exception?) {
                    callback.onError()
                }

                override fun onSuccess() {
                    callback.onSuccess()
                }
            })
}

private fun loadImage(imageView: ImageView,
                      url: String,
                      placeholder: Int,
                      error: Int,
                      callback: OnImageLoadListener) {
    Picasso.get()
            .load(url)
            .placeholder(placeholder)
            .error(error)
            .into(imageView, object : Callback {
                override fun onSuccess() {
                    callback.onSuccess()
                }

                override fun onError(e: Exception?) {
                    callback.onError()
                }
            })
}