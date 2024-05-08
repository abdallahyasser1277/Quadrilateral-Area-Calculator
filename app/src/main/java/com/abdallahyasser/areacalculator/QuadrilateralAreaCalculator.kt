package com.abdallahyasser.areacalculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
fun QuadrilateralAreaCalculator() {
    var sideA by remember { mutableStateOf("") }
    var sideB by remember { mutableStateOf("") }
    var sideH by remember { mutableStateOf("") }
    var sideD by remember { mutableStateOf("") }
    var sideG by remember { mutableStateOf("") }
    var result: String by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp) ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.reg), contentDescription = "Triangle",
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.24f)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xff222831))
        )
        Row {
            OutlinedTextField(
                value = sideA,
                onValueChange = { sideA = it },
                modifier = Modifier.fillMaxWidth(0.48f),
                label = { Text("الضلع أ") }
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.04f))
            OutlinedTextField(
                value = sideB,
                onValueChange = { sideB = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("الضلع ب") }
            )
        }
        Row {
            OutlinedTextField(
                value = sideH,
                onValueChange = { sideH = it },
                modifier = Modifier.fillMaxWidth(0.48f),
                label = { Text("الضلع هـ") }
            )
            Spacer(modifier = Modifier.fillMaxWidth(0.04f))
            OutlinedTextField(
                value = sideD,
                onValueChange = { sideD = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("الضلع د") }
            )
        }

        OutlinedTextField(
            value = sideG,
            onValueChange = { sideG = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("الوتر جـ") }
        )

        Button(
            shape = RoundedCornerShape(8.dp),
            onClick = { result=calculateArea(sideA, sideB, sideH, sideD, sideG) },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Calculate Area")
        }

        Text(
            text = "Area: ",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = result,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Preview
@Composable
fun PreviewQuadrilateralAreaCalculator() {
    QuadrilateralAreaCalculator()
}

private fun calculateArea(sideA: String, sideB: String, sideH: String, sideD: String, sideG: String):String {
    val quadrilater=Quadrilater(
        sideA.toFloatOrNull(),
        sideB.toFloatOrNull(),
        sideH.toFloatOrNull(),
        sideD.toFloatOrNull(),
        sideG.toFloatOrNull(),
        .0)

    with(quadrilater) {
        if (a != null && b != null && h != null && d != null && g != null) {
            val s1 = (a + b + g) / 2
            val area1 = sqrt((s1 * (s1 - a) * (s1 - b) * (s1 - g)).toDouble())
            val s2 = (h + d + g) / 2
            val area2 = sqrt((s2 * (s2 - h) * (s2 - d) * (s2 - g)).toDouble())
            area = area1 + area2
            // Update the area state variable
            if (area1.toString()=="NaN" || area2.toString()=="NaN")
                return "Error:\n اطوال الاضلاع غير منطقية"
            return area.toString()
        }
    }

    return "Error:\n يجب ان تكون المدخلات ارقام انجليزية "
}
