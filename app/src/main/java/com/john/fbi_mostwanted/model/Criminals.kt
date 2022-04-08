package com.john.fbi_mostwanted.model


import com.google.gson.annotations.SerializedName

data class Criminals(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("total")
    val total: Int
)