package cesarferreira.faker

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

private val DEFAULT_PLACEHOLDER = R.color.defaultPlaceholder
private val DEFAULT_ERROR = R.color.errorPlaceholder

class Views

fun ImageView.loadFromUrl(
    url: String,
    placeholder: Int = DEFAULT_PLACEHOLDER,
    error: Int = DEFAULT_ERROR,
    onLoadingCompleted: () -> (Unit) = {}
) =
    loadImage(
        imageView = this,
        url = url,
        placeholder = placeholder,
        onLoadingCompleted = onLoadingCompleted,
        error = error
    )

fun ImageView.loadFromUrl(
    url: String,
    placeholder: Drawable,
    error: Drawable,
    onLoadingCompleted: () -> (Unit) = {}
) =
    loadImage(
        imageView = this,
        url = url,
        placeholder = placeholder,
        onLoadingCompleted = onLoadingCompleted,
        error = error
    )

fun ImageView.loadRandomImage(onLoadingCompleted: () -> (Unit) = {}) {
    this.post {
        loadImage(
            imageView = this,
            url = Faker.getRandomImage(this.measuredWidth, this.measuredHeight),
            placeholder = DEFAULT_PLACEHOLDER,
            onLoadingCompleted = onLoadingCompleted,
            error = DEFAULT_ERROR
        )
    }
}

fun ImageView.loadRandomImage(
    width: Int,
    height: Int,
    onLoadingCompleted: () -> (Unit) = {}
) =
    loadImage(
        imageView = this,
        url = Faker.getRandomImage(width, height),
        placeholder = DEFAULT_PLACEHOLDER,
        onLoadingCompleted = onLoadingCompleted,
        error = DEFAULT_ERROR
    )

private fun loadImage(
    imageView: ImageView,
    url: String,
    placeholder: Drawable,
    error: Drawable,
    onLoadingCompleted: () -> (Unit)
) {

    GlideApp.with(imageView.context)
        .load(url)
        .placeholder(placeholder)
        .addListener(requestListener(onLoadingCompleted))
        .error(error)
        .into(imageView)
}

private fun requestListener(onLoadingCompleted: () -> Unit): RequestListener<Drawable> {
    return object : RequestListener<Drawable> {
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {
            onLoadingCompleted()
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            onLoadingCompleted()
            return false
        }
    }
}

private fun loadImage(
    imageView: ImageView,
    url: String,
    placeholder: Int,
    error: Int,
    onLoadingCompleted: () -> (Unit)
) {

    GlideApp.with(imageView.context)
        .load(url)
        .placeholder(placeholder)
        .error(error)
        .addListener(requestListener(onLoadingCompleted))
        .into(imageView)
}
