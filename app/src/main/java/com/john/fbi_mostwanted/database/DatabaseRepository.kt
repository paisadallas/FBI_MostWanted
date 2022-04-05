package com.john.fbi_mostwanted.database

import com.john.fbi_mostwanted.model.Criminals


interface DatabaseRepository{
    suspend fun insertItem(newItem: Criminals)
    suspend fun getData(): List<Criminals>
    suspend fun delete(item:List<Criminals>)
}

class DatabaseRepositoryImpl(
    private  val itemDatabase: ItemDao
):DatabaseRepository {
    override suspend fun insertItem(newItem: Criminals) =
        itemDatabase.insertItem(newItem)


    override suspend fun getData(): List<Criminals> =
        itemDatabase.getAllData()


    override suspend fun delete(item: List<Criminals>) =
        itemDatabase.delete(item)

}