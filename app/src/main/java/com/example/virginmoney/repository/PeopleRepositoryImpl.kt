package com.example.virginmoney.repository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.virginmoney.model.People
import com.example.virginmoney.utils.ApiInterface
import com.example.virginmoney.utils.RetrofitHelper
import kotlinx.coroutines.coroutineScope

class PeopleRepositoryImpl: PeopleRepository {

    override suspend fun getPeople(): ArrayList<People> {
        var peopleList: ArrayList<People> by mutableStateOf(arrayListOf())
        coroutineScope {
            val apiService = RetrofitHelper.getInstance().create(ApiInterface::class.java)
            try {
                peopleList = apiService.getPeople() as ArrayList<People>
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return peopleList
    }

}