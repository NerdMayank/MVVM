package com.example.lifeccyclel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Observer: LifecycleObserver {
    var counter=0
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){

    }
    public fun counter(){
        counter++;
    }
}