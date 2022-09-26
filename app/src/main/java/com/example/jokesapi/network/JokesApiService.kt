package com.example.jokesapi.network

import com.google.gson.annotations.SerializedName

data class JokesApiService (

    /*@SerializedName("joke")
    val joke:String*/

    @SerializedName("attachments")
    var attachments: List<JokeSlack>,
    @SerializedName("response_type")
    var response_type: String,
    @SerializedName("username")
    var username: String,
    )
