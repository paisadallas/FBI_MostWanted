package com.john.fbi_mostwanted.model


import com.google.gson.annotations.SerializedName


data class File(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)