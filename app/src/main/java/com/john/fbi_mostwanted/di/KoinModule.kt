package com.john.fbi_mostwanted.di

import android.content.Context
import androidx.room.Room
import com.john.fbi_mostwanted.database.*
import com.john.fbi_mostwanted.res.FbiApi
import com.john.fbi_mostwanted.res.FbiRepository
import com.john.fbi_mostwanted.res.FbiRepositoryImpl
import com.john.fbi_mostwanted.viewmodel.FbiViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {

    fun providesLoggingInterceptors(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    fun providesHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build()

    fun providesNetworkServices(okHttpClient: OkHttpClient): FbiApi =
        Retrofit.Builder()
            .baseUrl(FbiApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(FbiApi::class.java)

    fun providesJokeRepo(networkServices:FbiApi):FbiRepository =
        FbiRepositoryImpl(networkServices)

    single { providesLoggingInterceptors() }
    single { providesHttpClient(get()) }
    single { providesNetworkServices(get()) }
    single { providesJokeRepo(get()) }
}

val applicationModule = module {

    fun providesJokeDatabase(context: Context): ItemDatabase =
        Room.databaseBuilder(
            context,
            ItemDatabase::class.java,
            "joke-db"
        ).build()

    fun providesDatabaseDao(jokeDatabase: ItemDatabase): ItemDao =
        jokeDatabase.getDao()

    fun providesDatabaseRepository(databaseDao:ItemDao):DatabaseRepository =
        DatabaseRepositoryImpl(databaseDao)

    single { providesJokeDatabase(androidContext()) }
    single { providesDatabaseDao(get()) }
    single { providesDatabaseRepository(get()) }

}

val viewModelModule = module {
    viewModel {FbiViewModel(get(),get())}
}