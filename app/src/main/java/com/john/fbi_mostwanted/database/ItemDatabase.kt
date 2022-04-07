package com.john.fbi_mostwanted.database

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.john.fbi_mostwanted.model.Criminals
import com.john.fbi_mostwanted.model.Item
import com.john.fbi_mostwanted.model.Value


@Database(
    entities = [Item::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun getDao():ItemDao
}

@Dao
interface ItemDao{

    @Insert(onConflict = REPLACE)
    suspend fun insertItem(newItem: List<Item> )

    @Query("SELECT * FROM item")
    suspend fun getAllData() :List<Item>

    @Delete
    suspend fun delete(item: List<Item>)
}