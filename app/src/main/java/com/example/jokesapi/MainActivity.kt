package com.example.jokesapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.jokesapi.network.IJokeService
import com.example.jokesapi.network.JokesApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// https://github.com/sameerkumar18/geek-joke-api
// https://geek-jokes.sameerkumar.website/api?format=json
class MainActivity : AppCompatActivity() {

    // lateinit var jokes: ArrayList<Jokes>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setupViews()

        val btJoke = findViewById<Button>(R.id.btNext)

        btJoke.setOnClickListener { loadJokes() }
    }

    private fun loadJokes(){
        val baseUrl="https://icanhazdadjoke.com/"
        val tvJoke = findViewById<TextView>(R.id.tvJoke)
        // tvJoke.text = "Broma encontrada!!!"
        // 1. Create an instance of retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // 2. Create an instance of the interface
        val jokeService : IJokeService = retrofit.create(IJokeService::class.java)

        // 3. Create a variable y trough the interface  assign the fun
        val request = jokeService.getJokes("json")

        // Implement the mtehods trough the request
        request.enqueue(object :Callback<JokesApiService>{
            override fun onResponse(
                call: Call<JokesApiService>,
                response: Response<JokesApiService>
            ) {
                if(response.isSuccessful) {
                    tvJoke.text = response.body()!!.attachments[0].text // assign !!
                }
            }

            override fun onFailure(call: Call<JokesApiService>, t: Throwable) {
                println("ERROR")
            }

        })
    }




}