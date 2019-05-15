package cesarferreira.faker.demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.ImageView
import cesarferreira.faker.Faker
import cesarferreira.faker.loadFromUrl
import cesarferreira.faker.loadRandomImage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ListItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

//        val imageView : ImageView = ImageView()
//
//        // Load a random image
//        imageView.loadRandomImage()
//
//        // Load the image url
//        imageView.loadFromUrl("http://example.com/image01.png")
//
//        // Load a random image with this size
//        imageView.loadRandomImage(300, 400)
//
//        // load the image url with this placeholder and error
//        imageView.loadFromUrl("http://example.com/image01.png", R.color.DEFAULT_PLACEHOLDER, R.color.errorPlaceholder)
//
//        // load the image url with this placeholder and error
//        imageView.loadFromUrl("http://example.com/image01.png", R.drawable.placeholder, R.drawable.error)

    }

    private fun setupRecyclerView() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        adapter = ListItemsAdapter(getFakeItems() as ArrayList<ItemViewModel>)

        recyclerView.adapter = adapter
    }

    private fun getFakeItems() = (0..500).map { ItemViewModel(it, Faker.getRandomImage(400, 300)) }.toList()

}
