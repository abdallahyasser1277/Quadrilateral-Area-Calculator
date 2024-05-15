package com.abdallahyasser.areacalculator.histroyScreen


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdallahyasser.areacalculator.MyApplication
import com.abdallahyasser.areacalculator.quadrilateralScreen.Quadrilater
import com.abdallahyasser.areacalculator.repo.Dao
import com.abdallahyasser.areacalculator.repo.MyDatabase
import com.abdallahyasser.areacalculator.triangleScreen.Traingle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryVM:ViewModel() {

    private var dao:Dao = MyDatabase.getDaoInstance(MyApplication.getAppContext())

    var isTriangleOrQuadrilateral:Boolean =true

    var tList by mutableStateOf(emptyList<Traingle>())
    var qList by mutableStateOf(emptyList<Quadrilater>())

    init {
        reload()
    }

    fun reload(){
        viewModelScope.launch(Dispatchers.IO) {
            val tempTList=dao.getAll()
            val tempQList=dao.getAllQuadrilaters()
            withContext(Dispatchers.Main) {
                tList = tempTList
                qList = tempQList
            }
        }
    }



}