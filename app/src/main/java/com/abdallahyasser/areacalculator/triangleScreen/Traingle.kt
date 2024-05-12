package com.abdallahyasser.areacalculator.triangleScreen

import com.abdallahyasser.areacalculator.ui.theme.Values
import java.util.Date
import kotlin.math.sqrt

data class Traingle(
    val a:Float?,
    val b:Float?,
    val c:Float?,
    var area:Double?,
    var note:String="",
    var date :String?=""){
    fun calculateArea():String{
        if (a != null && b != null && c != null) {
            val s = (a + b + c) / 2
            area = sqrt((s * (s - a) * (s - b) * (s - c)).toDouble())
            // Update the area state variable
            if (area.toString()=="NaN")
                return "Error:\n اطوال الاضلاع غير منطقية"
            date = Values.sdf.format(Date())
            return area.toString()
        }
        return "Error:\n يجب ان تكون المدخلات ارقام انجليزية "
    }
}