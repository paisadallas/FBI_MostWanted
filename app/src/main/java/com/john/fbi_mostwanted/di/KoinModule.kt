package com.john.fbi_mostwanted.di

import com.john.fbi_mostwanted.res.FbiApi
import com.john.fbi_mostwanted.res.FbiRepository
import com.john.fbi_mostwanted.res.FbiRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    fun providesLoggingInterceptors():HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

    fun providesHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build()

    fun providesNetworkServices(okHttpClient: OkHttpClient):FbiApi =
        Retrofit.Builder()
            .baseUrl(FbiApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(FbiApi::class.java)

    fun providesFbiRepo(networkServices:FbiApi): FbiRepository =
        FbiRepositoryImpl(networkServices)

    single { providesLoggingInterceptors() }
    single { providesHttpClient(get()) }
    single {providesNetworkServices(get())}
    single {providesFbiRepo(get())}
}