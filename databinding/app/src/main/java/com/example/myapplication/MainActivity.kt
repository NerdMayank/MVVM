package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)


        mainViewModel= ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.factsLiveData.observe(this, Observer {
            binding.factsTextView.text=it
        })

        binding.btnUpdate.setOnClickListener {
            mainViewModel.updateLiveData()
        }
        val quote=Quote("Do or do not. There is no try.","Yoda")
        binding.quote=quote

    }
}