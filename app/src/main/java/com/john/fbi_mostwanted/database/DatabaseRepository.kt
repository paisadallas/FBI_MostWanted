package com.john.fbi_mostwanted.database

import com.john.fbi_mostwanted.model.Value


interface DatabaseRepository{
    suspend fun insertItem(newItem: List<Value>)
    suspend fun getData(): List<Value>
    suspend fun delete(item:List<Value>)
}

class DatabaseRepositoryImpl(
    private  val itemDatabase: ItemDao
):DatabaseRepository {
    override suspend fun insertItem(newItem: List<Value>) =
        itemDatabase.insertItem(newItem)


    override suspend fun getData(): List<Value> =
        itemDatabase.getAllData()


    override suspend fun delete(item: List<Value>) =
        itemDatabase.delete(item)

}