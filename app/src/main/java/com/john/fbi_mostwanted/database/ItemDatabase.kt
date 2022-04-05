package com.john.fbi_mostwanted.database

import androidx.room.RoomDatabase
import com.john.fbi_mostwanted.model.Criminals

abstract class ItemDatabase : RoomDatabase() {
    abstract fun getDao():ItemDao
}

interface ItemDao{
    suspend fun insertItem(newItem: Criminals )

    suspend fun getAllData() :List<Criminals>

    suspend fun delete(item: List<Criminals>)
}