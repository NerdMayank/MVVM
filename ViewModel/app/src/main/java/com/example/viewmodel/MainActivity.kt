package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txt:TextView
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel= ViewModelProvider(this)[MainViewModel::class.java]
        txt=findViewById(R.id.text)
        setText()
    }

    private fun setText() {
        txt.text=mainViewModel.count.toString()
    }

    fun increment(view: View) {
        mainViewModel.increment()
        setText()
    }

}