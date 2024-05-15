package com.abdallahyasser.areacalculator.triangleScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdallahyasser.areacalculator.MyApplication
import com.abdallahyasser.areacalculator.repo.Dao
import com.abdallahyasser.areacalculator.repo.MyDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TriangleVM:ViewModel() {

    private var dao: Dao = MyDatabase.getDaoInstance(MyApplication.getAppContext())
    var traingle by mutableStateOf(Traingle(0,0f,0f,0f,0.0))


    fun getLastItem(): Traingle {
        viewModelScope.launch(Dispatchers.Main){
            traingle=dao.getLastTraingle()
        }
        return traingle
    }
    fun saveCalculation(t: Traingle) {
        viewModelScope.launch(Dispatchers.IO) {
            val lastTraingle=dao.getLastTraingle()
            if(lastTraingle.area!=t.area)
            dao.insert(t)
        }
    }
}