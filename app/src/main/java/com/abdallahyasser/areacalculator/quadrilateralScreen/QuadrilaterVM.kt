package com.abdallahyasser.areacalculator.quadrilateralScreen

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

class QuadrilaterVM:ViewModel() {
    var quad by mutableStateOf(Quadrilater(0,1f,1f,1f,1f,1f,0.0))
    private var dao: Dao = MyDatabase.getDaoInstance(MyApplication.getAppContext())
    fun getLastItem():Quadrilater{
        viewModelScope.launch(Dispatchers.Main){
            quad=dao.getLastQuadrilater()
        }
        return quad
    }
    fun saveCalculation(q: Quadrilater){
        viewModelScope.launch(Dispatchers.IO) {
            val quadrilater=dao.getLastQuadrilater()
            if(quadrilater.area!=q.area)
            dao.insert(q)
        }
    }

}