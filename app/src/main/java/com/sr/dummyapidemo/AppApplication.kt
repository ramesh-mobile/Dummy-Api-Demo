package com.sr.dummyapidemo

import android.app.Application

/**
 * Created by ramesh on 16-10-2021
 */
class AppApplication : Application(){
    companion object{
        lateinit var instance : Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}