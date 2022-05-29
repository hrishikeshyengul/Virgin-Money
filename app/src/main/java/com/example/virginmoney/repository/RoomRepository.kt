package com.example.virginmoney.repository

import com.example.virginmoney.model.Room

interface RoomRepository {

    suspend fun getRoom(): ArrayList<Room>
}