package com.abdallahyasser.areacalculator.histroyScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdallahyasser.areacalculator.R
import com.abdallahyasser.areacalculator.quadrilateralScreen.Quadrilater
import com.abdallahyasser.areacalculator.triangleScreen.Traingle

@Preview
@Composable
fun ItemCard(){
    val s=Quadrilater(2,2f,3f,2f,2f,2f,null)
    s.calculateArea()
    Card {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()

            ) {
                Icon(
                    painterResource(id = R.drawable.rectangle),
                    contentDescription ="",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(0.15f)
                        .padding(8.dp))
                Text(text = s.area.toString(),
                    fontSize = 32.sp,
                    maxLines = 1,
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(start = 8.dp, end = 8.dp))
                Icon(if(s.note==""){Icons.Default.Add}else{Icons.Default.Create},
                    contentDescription ="",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(0.15f))
            }
            Text(text =s.date.toString(),
                modifier = Modifier.padding(start = 8.dp, end = 8.dp))
            Text(text = "demo note demo note demo note demo note",
                modifier = Modifier.padding(8.dp))
        }

    }

}
@Composable
fun ItemCard(s :Quadrilater){
    Card {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()

            ) {
                Icon(
                    painterResource(id = R.drawable.rectangle),
                    contentDescription ="",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(0.15f)
                        .padding(8.dp))
                Text(text = s.area.toString(),
                    fontSize = 32.sp,
                    maxLines = 1,
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(start = 8.dp, end = 8.dp))
                Icon(if(s.note==""){Icons.Default.Add}else{Icons.Default.Create},
                    contentDescription ="",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(0.15f))
            }
            Text(text =s.date.toString(),
                modifier = Modifier.padding(start = 8.dp, end = 8.dp))
            Text(text = "demo note demo note demo note demo note",
                modifier = Modifier.padding(8.dp))
        }

    }

}
@Composable
fun ItemCard(s :Traingle){
    Card {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()

            ) {
                Icon(
                    painterResource(id = R.drawable.triangle),
                    contentDescription ="",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(0.15f)
                        .padding(8.dp))
                Text(text = s.area.toString(),
                    fontSize = 32.sp,
                    maxLines = 1,
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(start = 8.dp, end = 8.dp))
                Icon(if(s.note==""){Icons.Default.Add}else{Icons.Default.Create},
                    contentDescription ="",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(0.15f))
            }
            Text(text =s.date.toString(),
                modifier = Modifier.padding(start = 8.dp, end = 8.dp))
            Text(text = "demo note demo note demo note demo note",
                modifier = Modifier.padding(8.dp))
        }
    }
}