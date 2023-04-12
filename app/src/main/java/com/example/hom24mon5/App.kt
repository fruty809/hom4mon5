package com.example.hom24mon5

import android.app.Application
import androidx.room.Room
import com.example.hom24mon5.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var appDatabase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "love-file")
            .allowMainThreadQueries().build()
    }
}