package com.example.lifeccyclel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val tv:TextView
        get() = findViewById(R.id.text)
    private val observer=Observer()
    val btn:Button
        get() = findViewById(R.id.btn)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(observer)

    }

    fun count(view: View) {
        observer.counter()
        setText()
    }

    private fun setText() {
        tv.text=observer.counter.toString()
    }
}