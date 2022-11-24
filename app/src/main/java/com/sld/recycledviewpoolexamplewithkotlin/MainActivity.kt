package com.sld.recycledviewpoolexamplewithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.sld.recycledviewpoolexamplewithkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvItem.apply {
            val adapter = ItemAdapter(buildItemList())
            val layoutManager = LinearLayoutManager(context)

            this.adapter = adapter
            this.layoutManager = layoutManager
            setHasFixedSize(false)
        }
    }

    private fun buildItemList(): MutableList<Items.Item> {
        var itemList: MutableList<Items.Item> = mutableListOf()
        for (i in 0..9) {
            Log.d("test", "a: $i")
            var item: Items.Item = Items.Item("Item $i", buildSubItemList())
            itemList.add(item)
        }
        return itemList
    }

    private fun buildSubItemList(): MutableList<Items.SubItem> {
        var subItemList: MutableList<Items.SubItem> = mutableListOf()
        for (i in 0..2) {
            Log.d("test", "b: $i")
            var subItem: Items.SubItem = Items.SubItem("Sub Item $i", "Description $i")
            subItemList.add(subItem)
        }
        return subItemList
    }
}