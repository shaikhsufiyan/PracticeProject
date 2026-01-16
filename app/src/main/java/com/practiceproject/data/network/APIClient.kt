package com.practiceproject.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {

    val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val apiInterface: APIInterface by lazy {
        retrofit.create(APIInterface::class.java)
    }
}