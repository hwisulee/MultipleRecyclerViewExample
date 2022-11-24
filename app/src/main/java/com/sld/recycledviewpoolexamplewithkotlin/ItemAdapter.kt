package com.sld.recycledviewpoolexamplewithkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sld.recycledviewpoolexamplewithkotlin.databinding.LayoutItemBinding

class ItemAdapter(buildItemList: MutableList<Items.Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private val viewPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()
    private var itemList: MutableList<Items.Item> = buildItemList

    inner class ViewHolder(private val binding: LayoutItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Items.Item) {
            with(binding) {
                binding.tvItemTitle.text = item.itemTitle

                binding.rvSubItem.apply {
                    val adapter = SubItemAdapter(item.subItemList)
                    val layoutManager = LinearLayoutManager(
                        binding.tvItemTitle.context,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    layoutManager.initialPrefetchItemCount = item.subItemList.size

                    this.adapter = adapter
                    this.layoutManager = layoutManager
                    setRecycledViewPool(viewPool)
                    setHasFixedSize(false)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val view = LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int ) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}
