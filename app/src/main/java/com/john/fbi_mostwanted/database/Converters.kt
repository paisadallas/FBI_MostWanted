package com.john.fbi_mostwanted.database


import androidx.room.TypeConverter
import com.john.fbi_mostwanted.model.File
import com.john.fbi_mostwanted.model.Image

class Converters {

    @TypeConverter
    fun toListOfStrings(flatStringList: String): List<String> {
        return flatStringList.split(",")
    }
    @TypeConverter
    fun fromListOfStrings(listOfString: List<String>): String {
        return listOfString.joinToString(",")
    }

    @TypeConverter
    fun toFileOfStrings(flatStringList: String): List<File> {
        return listOf(File(flatStringList,flatStringList))
    }
    @TypeConverter
    fun fromListOfFile(listOfString: List<File>): String {
        return listOfString[0].name
    }

    @TypeConverter
    fun toImageOfStrings(flatStringList: String): List<Image> {
        return listOf(Image(flatStringList,flatStringList,flatStringList,flatStringList))
    }
    @TypeConverter
    fun fromListOfImage(listOfString: List<Image>): String {
        return listOfString[0].large
    }




}