package com.abdallahyasser.areacalculator


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.ui.graphics.vector.ImageVector

interface Destinations {
    val route: String
    val icon: Int
    val title: String
}

object Quadrilateral:Destinations{
    override val route = "Quadrilateral"
    override val icon = R.drawable.reg
    override val title= "Quadrilateral"
}
object Triangle:Destinations{
    override val route= "Triangle"
    override val icon =R.drawable.tr
    override val title= "Triangle"
}
object History:Destinations{
    override val route= "History"
    override val icon= R.drawable.quadrilateral
    override val title= "History"
}
object About:Destinations{
    override val route= "About"
    override val icon= R.drawable.quadrilateral
    override val title= "About"
}