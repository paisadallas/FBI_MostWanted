package com.john.fbi_mostwanted.res

import com.john.fbi_mostwanted.model.Item
import retrofit2.Response


interface FbiRepository{

    suspend fun getAllData() : Response<Item>
}

class FbiRepositoryImpl(
    private val fbiApi: FbiApi
) : FbiRepository {
    override suspend fun getAllData(): Response<Item> =
        fbiApi.getCriminals()
}