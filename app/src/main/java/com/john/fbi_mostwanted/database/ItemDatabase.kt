package com.john.fbi_mostwanted.database

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.john.fbi_mostwanted.model.Value


@Database(
    entities = [Value::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun getDao():ItemDao
}

@Dao
interface ItemDao{

    @Insert(onConflict = REPLACE)
    suspend fun insertItem(newItem: List<Value> )

    @Query("SELECT * FROM value")
    suspend fun getAllData() :List<Value>

    @Delete
    suspend fun delete(item: List<Value>)
}