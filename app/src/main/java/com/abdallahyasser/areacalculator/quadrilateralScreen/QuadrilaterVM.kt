package com.abdallahyasser.areacalculator.quadrilateralScreen

import androidx.lifecycle.ViewModel

class QuadrilaterVM:ViewModel() {
     private var list= listOf(
        Quadrilater(1,null,null,null,null,null,null),
        Quadrilater(2,null,null,null,null,null,null),
        Quadrilater(2,null,null,null,null,null,null),
        Quadrilater(2,2f,2f,2f,2f,2f,null))

    fun getLastItem():Quadrilater{
        return list.last()
    }
    fun saveCalculation(q:Quadrilater){
        list=list+q
    }

}