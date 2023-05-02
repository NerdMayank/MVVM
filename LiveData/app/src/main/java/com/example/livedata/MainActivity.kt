package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    private val text:TextView
        get() = findViewById(R.id.text)
    private val btnUpdate:Button
        get() = findViewById(R.id.btnUpdate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel= ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.factsLiveData.observe(this, Observer {
            text.text=it
        })

        btnUpdate.setOnClickListener {
            mainViewModel.updateLiveData()
        }
    }
}