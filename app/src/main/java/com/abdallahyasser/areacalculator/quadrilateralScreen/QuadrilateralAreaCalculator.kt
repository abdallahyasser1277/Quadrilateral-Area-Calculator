package com.abdallahyasser.areacalculator.quadrilateralScreen

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
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abdallahyasser.areacalculator.R

@Composable
fun QuadrilateralAreaCalculator() {

    val vM:QuadrilaterVM=viewModel()
    var quadrilater=vM.getLastItem()

    var sideA by remember { mutableStateOf(quadrilater.a.toString()) }
    var sideB by remember { mutableStateOf(quadrilater.b.toString()) }
    var sideH by remember { mutableStateOf(quadrilater.h.toString()) }
    var sideD by remember { mutableStateOf(quadrilater.d.toString()) }
    var sideG by remember { mutableStateOf(quadrilater.g.toString()) }
    var result: String by remember { mutableStateOf(quadrilater.area.toString()) }

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
            onClick = {
                quadrilater= Quadrilater(
                    a=sideA.toFloatOrNull(),
                    b=sideB.toFloatOrNull(),
                    h=sideH.toFloatOrNull(),
                    d=sideD.toFloatOrNull(),
                    g=sideG.toFloatOrNull(),
                    area = .0)

                result=quadrilater.calculateArea()

                if(result[0]!= 'E'){
                    vM.saveCalculation(quadrilater)
                }

            },
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