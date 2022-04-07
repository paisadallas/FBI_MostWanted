package com.john.fbi_mostwanted.database

import com.john.fbi_mostwanted.model.Criminals
import com.john.fbi_mostwanted.model.Item
import com.john.fbi_mostwanted.model.Value


interface DatabaseRepository{
    suspend fun insertItem(newItem: List<Item>)
    suspend fun getData(): List<Item>
    suspend fun delete(item:List<Item>)
}

class DatabaseRepositoryImpl(
    private  val itemDatabase: ItemDao
):DatabaseRepository {
    override suspend fun insertItem(newItem: List<Item>) =
        itemDatabase.insertItem(newItem)


    override suspend fun getData(): List<Item> =
        itemDatabase.getAllData()


    override suspend fun delete(item: List<Item>) =
        itemDatabase.delete(item)

}