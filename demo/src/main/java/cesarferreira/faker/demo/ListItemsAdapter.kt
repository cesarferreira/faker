package cesarferreira.faker.demo

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import cesarferreira.faker.loadFromUrl
import kotlinx.android.synthetic.main.item_list_item.view.thumbnail

class ListItemsAdapter(private val items: ArrayList<ItemViewModel>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<ListItemsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ItemViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bind(item: ItemViewModel) {
            itemView.thumbnail.loadFromUrl(url = item.thumbnail, onLoadingCompleted = {})
            itemView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    item.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
