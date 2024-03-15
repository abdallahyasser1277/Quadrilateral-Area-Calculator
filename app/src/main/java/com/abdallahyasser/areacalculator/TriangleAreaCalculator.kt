package com.abdallahyasser.areacalculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import kotlin.math.sqrt

@Composable
fun TriangleAreaCalculator() {
    var sideA by remember { mutableStateOf("") }
    var sideB by remember { mutableStateOf("") }
    var sideC by remember { mutableStateOf("") }
    var area by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.tr), contentDescription = "Triangle",
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.24f)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xff222831))
        )



        OutlinedTextField(
            value = sideA,
            onValueChange = { sideA = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("الضلع أ") }
        )
        OutlinedTextField(
            value = sideB,
            onValueChange = { sideB = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("الضلع ب") }
        )
        OutlinedTextField(
            value = sideC,
            onValueChange = { sideC = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("الضبع جـ") }
        )

        Button(
            shape = RoundedCornerShape(12.dp),
            onClick = { area=calculateArea(sideA, sideB, sideC) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate Area")
        }

        Text(
            text = "Area: ",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = area,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Preview
@Composable
fun PreviewTriangleAreaCalculator() {
    TriangleAreaCalculator()
}

private fun calculateArea(sideA: String, sideB: String, sideC: String):String {
    val a = sideA.toFloatOrNull()
    val b = sideB.toFloatOrNull()
    val c = sideC.toFloatOrNull()

    if (a != null && b != null && c != null) {
        val s = (a + b + c) / 2
        val area = sqrt((s * (s - a) * (s - b) * (s - c)).toDouble())
        // Update the area state variable
        if (area.toString()=="NaN")
            return "Error:\n اطوال الاضلاع غير منطقية"
        return area.toString()
    }
    return "Error:\n يجب ان تكون المدخلات ارقام انجليزية "
}