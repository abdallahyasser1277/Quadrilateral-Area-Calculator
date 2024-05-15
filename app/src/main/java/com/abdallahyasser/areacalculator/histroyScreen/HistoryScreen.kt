package com.abdallahyasser.areacalculator.histroyScreen




import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel
import com.abdallahyasser.areacalculator.quadrilateralScreen.Quadrilater
import com.abdallahyasser.areacalculator.triangleScreen.Traingle
import com.abdallahyasser.areacalculator.ui.theme.Pink80
import com.abdallahyasser.areacalculator.ui.theme.Purple40

@Composable
fun HistoryScreen() {
    val vM: HistoryVM = viewModel()
    vM.reload()
    var isTraingleOrQuadrilater by remember {
        mutableStateOf(vM.isTriangleOrQuadrilateral)
    }
    Column(modifier = Modifier.fillMaxSize()) {

        LazyColumn(modifier = Modifier.weight(0.9f)) {
            items(if(isTraingleOrQuadrilater){vM.tList}else{vM.qList}){
                if(it is Traingle)ItemCard(it)
                if (it is Quadrilater) ItemCard(it)
            }

        }

        Row(modifier = Modifier
            .fillMaxWidth()) {
            Button(modifier = Modifier
                .weight(0.5f)
                .padding(4.dp),
                colors = if(!isTraingleOrQuadrilater)
                {ButtonDefaults.buttonColors(Purple40)}
                else
                {ButtonDefaults.buttonColors(Pink80)},
                onClick = {
                    isTraingleOrQuadrilater= true
                }) {
                Text(text = " Traingles ",
                    color = MaterialTheme.colors.onPrimary)
            }
            Button(modifier = Modifier
                .weight(0.5f)
                .padding(4.dp),
                colors = if(isTraingleOrQuadrilater)
                {ButtonDefaults.buttonColors(Purple40)}
                else
                {ButtonDefaults.buttonColors(Pink80)}
                ,
                onClick = {
                    isTraingleOrQuadrilater= false
                }) {
                Text(text = " Quadrilaters ",
                    color = MaterialTheme.colors.onPrimary)
            }
        }
    }
}
