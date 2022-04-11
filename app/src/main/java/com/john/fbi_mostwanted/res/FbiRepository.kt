package com.john.fbi_mostwanted.res

import com.john.fbi_mostwanted.model.Criminals
import retrofit2.Response


interface FbiRepository{

    suspend fun getAllData() : Response<Criminals>
}

class FbiRepositoryImpl(
    private val fbiApi: FbiApi
) : FbiRepository {
    override suspend fun getAllData(): Response<Criminals> =
        fbiApi.getCriminals()
}