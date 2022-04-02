package com.john.fbi_mostwanted.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("items")
    val items: List<ItemX>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("total")
    val total: Int
)