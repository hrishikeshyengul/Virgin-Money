package com.example.virginmoney.repository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.virginmoney.model.People
import com.example.virginmoney.model.Room
import com.example.virginmoney.utils.ApiInterface
import com.example.virginmoney.utils.RetrofitHelper
import kotlinx.coroutines.coroutineScope

class RoomRepositoryImpl: RoomRepository {
    override suspend fun getRoom(): ArrayList<Room> {
        var roomList: ArrayList<Room> by mutableStateOf(arrayListOf())
        coroutineScope {
            val apiService = RetrofitHelper.getInstance().create(ApiInterface::class.java)
            try {
                roomList = apiService.getRoom() as ArrayList<Room>
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return roomList
    }
}