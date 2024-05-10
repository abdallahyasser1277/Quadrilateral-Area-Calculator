package com.abdallahyasser.areacalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abdallahyasser.areacalculator.about.AboutScreen
import com.abdallahyasser.areacalculator.histroy.HistoryScreen
import com.abdallahyasser.areacalculator.quadrilateralScreen.Quadrilater
import com.abdallahyasser.areacalculator.quadrilateralScreen.QuadrilateralAreaCalculator
import com.abdallahyasser.areacalculator.triangleScreen.Traingle
import com.abdallahyasser.areacalculator.triangleScreen.TriangleAreaCalculator
import com.abdallahyasser.areacalculator.ui.theme.AreaCalculatorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AreaCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}


@Composable
fun MyApp(){
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        MyBottomNavigation(navController = navController) }) {
        Box(modifier = Modifier.padding(it)){
            NavHost(navController = navController, startDestination = Quadrilateral.route) {
                composable(Quadrilateral.route){
                    QuadrilateralAreaCalculator()
                }
                composable(Triangle.route){
                    TriangleAreaCalculator()
                }
                composable(History.route){
                    HistoryScreen()
                }
                composable(About.route){
                    AboutScreen()
                }

            }
        }
    }
}
@Composable
fun MyBottomNavigation(navController: NavController){
    val destinations= listOf(Quadrilateral,Triangle,History,About)
    val selectedIndex = rememberSaveable {
        mutableStateOf(0)
    }
        BottomNavigation(backgroundColor = Color(0xFF222831)) {
            destinations.forEachIndexed { i: Int, destination: Destinations ->
                BottomNavigationItem(
                    label = { Text(text = destination.title, color = Color.White) },
                    selected = i == selectedIndex.value,
                    onClick = {
                        selectedIndex.value = i
                        navController.navigate(destination.route) {
                            popUpTo(Quadrilateral.route)
                            launchSingleTop = true
                        }
                    },
                    icon = {}
                )
            }
        }
}




