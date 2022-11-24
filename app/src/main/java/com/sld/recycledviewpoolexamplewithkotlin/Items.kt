package com.sld.recycledviewpoolexamplewithkotlin

sealed class Items{
    data class Item(
        val itemTitle: String,
        val subItemList: MutableList<SubItem>
    ): Items()

    data class SubItem(
        val subItemTitle: String,
        val subItemDesc: String
    ): Items()
}