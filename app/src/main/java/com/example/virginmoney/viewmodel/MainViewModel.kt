package com.example.virginmoney.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virginmoney.model.People
import com.example.virginmoney.model.Room
import com.example.virginmoney.repository.PeopleRepositoryImpl
import com.example.virginmoney.repository.RoomRepositoryImpl
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    lateinit var roomsListResponse:ArrayList<Room>
    lateinit var peopleListResponse:ArrayList<People>
    lateinit var peopleRepositoryImpl : PeopleRepositoryImpl
    lateinit var roomRepositoryImpl : RoomRepositoryImpl

    init {
        roomsListResponse = ArrayList()
        peopleListResponse = ArrayList()
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

