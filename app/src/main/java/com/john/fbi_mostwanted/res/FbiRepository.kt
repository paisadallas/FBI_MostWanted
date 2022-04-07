package com.john.fbi_mostwanted.res

import com.john.fbi_mostwanted.model.JokeList
import retrofit2.Response


interface FbiRepository{

    suspend fun getAllData() : Response<JokeList>
}

class FbiRepositoryImpl(
    private val fbiApi: FbiApi
) : FbiRepository {
    override suspend fun getAllData(): Response<JokeList> =
        fbiApi.getCriminals()
}