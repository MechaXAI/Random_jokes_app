package com.example.jokesapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var jokes: ArrayList<Jokes>
    var pos = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadJokes()
        setupViews()
    }
    private fun loadJokes(){
        val tvJoke = findViewById<TextView>(R.id.tvJoke)
        tvJoke.text = "Broma encontrada!!!"

    }




}