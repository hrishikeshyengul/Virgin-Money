package com.example.virginmoney.model

import com.google.gson.annotations.SerializedName

data class Room(@SerializedName("createdAt"    ) var createdAt    : String?  = null,
                @SerializedName("isOccupied"   ) var isOccupied   : Boolean? = null,
                @SerializedName("maxOccupancy" ) var maxOccupancy : Int?     = null,
                @SerializedName("id"           ) var id           : String?  = null)
