package com.abdallahyasser.areacalculator

import android.app.Application
import android.content.Context

class MyApplication:Application() {
    init {
        myApplication=this
    }
    companion object{
        private lateinit var myApplication: MyApplication
        fun getAppContext():Context= myApplication.applicationContext

    }

}