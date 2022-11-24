package com.sld.recycledviewpoolexamplewithkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sld.recycledviewpoolexamplewithkotlin.databinding.LayoutSubItemBinding

class SubItemAdapter(subItemList: MutableList<Items.SubItem>) : RecyclerView.Adapter<SubItemAdapter.ViewHolder>() {
    private var subItemList: MutableList<Items.SubItem> = subItemList

    inner class ViewHolder(private val binding: LayoutSubItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Items.SubItem) {
            with(binding) {
                binding.tvSubItemTitle.text = item.subItemTitle
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubItemAdapter.ViewHolder {
        val view = LayoutSubItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int ) {
        holder.bind(subItemList[position])
    }

    override fun getItemCount(): Int = subItemList.size
}