package com.example.jokesapi.network

import com.google.gson.annotations.SerializedName

data class JokeSlack (
    @SerializedName("fallback")
    var fallback: String,
    @SerializedName("footer")
    var footer: String,
    @SerializedName("text")
    var text: String,
)