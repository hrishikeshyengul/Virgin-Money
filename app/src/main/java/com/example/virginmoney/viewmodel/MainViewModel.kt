package com.example.virginmoney.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.model.People
import com.example.virginmoney.model.Room
import com.example.virginmoney.repository.PeopleRepositoryImpl
import com.example.virginmoney.repository.RoomRepositoryImpl
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var roomsListResponse:ArrayList<Room> by mutableStateOf(arrayListOf())
    var peopleListResponse:ArrayList<People> by mutableStateOf(arrayListOf())
    lateinit var peopleRepositoryImpl : PeopleRepositoryImpl
    lateinit var roomRepositoryImpl : RoomRepositoryImpl

    init {
        peopleRepositoryImpl = PeopleRepositoryImpl()
        roomRepositoryImpl = RoomRepositoryImpl()
    }

    fun getRoomsList() {
        viewModelScope.launch {
            roomsListResponse = roomRepositoryImpl.getRoom()
        }
    }

    fun getPeopleList() {
        viewModelScope.launch {
            peopleListResponse = peopleRepositoryImpl.getPeople()
        }
    }


}

