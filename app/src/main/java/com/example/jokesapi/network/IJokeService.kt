package com.example.jokesapi.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IJokeService {
     @GET("slack")
     fun getJokes(@Query("format") format:String ): Call<JokesApiService>
}