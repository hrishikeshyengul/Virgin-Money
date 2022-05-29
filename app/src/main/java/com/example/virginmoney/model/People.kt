package com.example.virginmoney.model

import com.google.gson.annotations.SerializedName

data class People(@SerializedName("createdAt"      ) var createdAt      : String? = null,
                  @SerializedName("firstName"      ) var firstName      : String? = null,
                  @SerializedName("avatar"         ) var avatar         : String? = null,
                  @SerializedName("lastName"       ) var lastName       : String? = null,
                  @SerializedName("email"          ) var email          : String? = null,
                  @SerializedName("jobtitle"       ) var jobtitle       : String? = null,
                  @SerializedName("favouriteColor" ) var favouriteColor : String? = null,
                  @SerializedName("id"             ) var id             : String? = null
)
