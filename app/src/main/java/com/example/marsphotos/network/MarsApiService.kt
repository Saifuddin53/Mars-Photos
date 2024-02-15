package com.example.marsphotos.network

import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface MarsApiService {

    @GET("photos")
    suspend fun getPhotos(): String
}

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

object MarsApi {
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}