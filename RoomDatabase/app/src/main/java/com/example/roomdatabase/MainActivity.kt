package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database=Room.databaseBuilder(applicationContext,
            ContactDatabase::class.java,
            "contactDB").build()

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"John","6299886629"))
        }

    }

    fun getData(view: View) {
        database.contactDao().getContact().observe(this, Observer {
            Log.d("Mayank",it.toString())
        })
    }
}