package com.abdallahyasser.areacalculator.quadrilateralScreen

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.abdallahyasser.areacalculator.ui.theme.Values.Companion.sdf
import java.util.Date
import kotlin.math.sqrt
@Entity
data class Quadrilater(
    @PrimaryKey(autoGenerate = true)
    val id :Int=0,
    val a: Float?,
    val b: Float?,
    val h: Float?,
    val d: Float?,
    val g: Float?,
    var area: Double?,
    var note: String = "",
    var date :String?=""
){
    fun calculateArea():String{
        if (a != null && b != null && h != null && d != null && g != null) {
            val s1 = (a + b + g) / 2
            val area1 = sqrt((s1 * (s1 - a) * (s1 - b) * (s1 - g)).toDouble())
            val s2 = (h + d + g) / 2
            val area2 = sqrt((s2 * (s2 - h) * (s2 - d) * (s2 - g)).toDouble())
            area = area1 + area2
            // Update the area state variable
            if (area1.toString()=="NaN" || area2.toString()=="NaN")
                return "Error:\n اطوال الاضلاع غير منطقية"
            date = sdf.format(Date())
            return area.toString()

        }
    return "Error:\n يجب ان تكون المدخلات ارقام انجليزية "
    }
}