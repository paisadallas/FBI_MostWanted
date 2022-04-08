package com.john.fbi_mostwanted.model


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("caption")
    val caption: Any?,
    @SerializedName("large")
    val large: String,
    @SerializedName("original")
    val original: String,
    @SerializedName("thumb")
    val thumb: String
)