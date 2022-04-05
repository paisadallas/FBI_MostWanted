package com.john.fbi_mostwanted.res

import com.john.fbi_mostwanted.model.Item
import com.john.fbi_mostwanted.res.FbiApi.Companion.BASE_URL
import retrofit2.Response
import retrofit2.http.GET

interface FbiApi{

    @GET(BASE_URL)
    suspend fun getCriminals():Response<Item>

    companion object{
        const val BASE_URL = "https://api.fbi.gov/wanted/v1/list"
    }
}