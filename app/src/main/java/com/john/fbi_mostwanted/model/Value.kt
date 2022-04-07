package com.john.fbi_mostwanted.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.john.fbi_mostwanted.database.Converters

@Entity
@TypeConverters(Converters::class)
data class Value(
    @SerializedName("categories")
    val categories: List<String>,
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("joke")
    val joke: String
)