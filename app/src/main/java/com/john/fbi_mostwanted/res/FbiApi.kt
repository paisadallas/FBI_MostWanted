package com.john.fbi_mostwanted.res

import com.john.fbi_mostwanted.model.Criminals
import retrofit2.Response
import retrofit2.http.GET

interface FbiApi{

    @GET(FBI_LIST)
    suspend fun getCriminals():Response<Criminals>

    companion object{
        const val BASE_URL = "https://api.fbi.gov/wanted/v1/"
        private const val FBI_LIST = "list"

//        const val BASE_URL = "http://api.icndb.com/jokes/"
//        private const val ALL_JOKE ="."
    }
}