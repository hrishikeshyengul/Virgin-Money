package com.example.virginmoney.repository

import com.example.virginmoney.model.People

interface PeopleRepository {

    suspend fun getPeople(): ArrayList<People>
}