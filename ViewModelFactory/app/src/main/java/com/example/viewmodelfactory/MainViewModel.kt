package com.example.viewmodelfactory

import androidx.lifecycle.ViewModel

class MainViewModel( initialValue:Int): ViewModel() {
    var count=initialValue

    fun increment(){
        count++
    }
}