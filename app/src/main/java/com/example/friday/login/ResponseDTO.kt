package com.example.friday.login

import com.google.gson.annotations.SerializedName

data class ResponseDTO(
    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("refresh_token")
    val refreshToken: String
)
