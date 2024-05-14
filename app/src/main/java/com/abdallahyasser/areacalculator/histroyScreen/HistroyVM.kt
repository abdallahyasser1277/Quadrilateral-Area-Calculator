package com.abdallahyasser.areacalculator.histroyScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abdallahyasser.areacalculator.MyApplication
import com.abdallahyasser.areacalculator.quadrilateralScreen.Quadrilater
import com.abdallahyasser.areacalculator.repo.Dao
import com.abdallahyasser.areacalculator.repo.MyDatabase
import com.abdallahyasser.areacalculator.triangleScreen.Traingle
import kotlinx.coroutines.launch

class HistroyVM:ViewModel() {

    private var dao:Dao = MyDatabase.getDaoInstance(MyApplication.getAppContext())
    var list= listOf(
        Quadrilater(1,null,null,null,null,null,null),
        Quadrilater(2,null,null,null,null,null,null),
        Quadrilater(2,null,null,null,null,null,null),
        Quadrilater(2,2f,2f,2f,2f,2f,null)
    )
    var list2= listOf(
        Traingle(0,null,null,null,null),
        Traingle(1,null,null,null,null),
        Traingle(2,null,null,null,null),
        Traingle(2,1f,1f,1f,null))

    var isTraingleOrQuadrilater:Boolean =true

    lateinit var tList: List<Traingle>
    lateinit var qList: List<Quadrilater>

    init {
        viewModelScope.launch {
            for (t in list2)
                dao.insert(t)
            for (q in list)
                dao.delete(q)

            tList=dao.getAll()
            qList=dao.getAllQuadrilaters()
        }
    }



}