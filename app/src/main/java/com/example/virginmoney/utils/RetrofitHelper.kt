package com.example.virginmoney.utils

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitHelper {

    var CALL_TIMEOUT = 5L
    var CONNECT_TIMEOUT = 300L
    var READ_TIMEOUT = 300L
    var WRITE_TIMEOUT = 300L

    var gson = GsonBuilder()
        .setLenient()
        .create()

    var httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        .callTimeout(CALL_TIMEOUT, TimeUnit.MINUTES)
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)

    val baseUrl = "https://61e947967bc0550017bc61bf.mockapi.io/api/v1/"


    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()
    }
}