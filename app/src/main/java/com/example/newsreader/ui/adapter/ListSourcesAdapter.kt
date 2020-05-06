package com.example.newsreader.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsreader.R
import com.example.newsreader.models.Source
import com.example.newsreader.ui.holder.ItemSourceHolder
import com.example.newsreader.utils.OnItemClickListener


class ListSourcesAdapter(val list: ArrayList<Source> = ArrayList()) : RecyclerView.Adapter<ItemSourceHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener<Source>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSourceHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_source, parent, false)
        return ItemSourceHolder(view)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener<Source>) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onBindViewHolder(holder: ItemSourceHolder, position: Int) {
        holder.bind(list.get(position))
        holder.itemView.setOnClickListener { it ->
            if(onItemClickListener != null){
                onItemClickListener.onClicked(list.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
