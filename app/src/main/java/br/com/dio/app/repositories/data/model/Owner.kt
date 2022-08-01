package br.com.dio.app.repositories.data.model

import com.google.gson.annotations.SerializedName

data class Owner (
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarURL: String,
    @SerializedName("html_url")
    val htmlURL: String
)