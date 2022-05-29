package com.example.virginmoney.utils

import com.example.virginmoney.model.People
import com.example.virginmoney.model.Room
import retrofit2.http.GET

interface ApiInterface {

    @GET("people")
    suspend fun getPeople() : List<People>

    @GET("rooms")
    suspend fun getRoom() : List<Room>
}