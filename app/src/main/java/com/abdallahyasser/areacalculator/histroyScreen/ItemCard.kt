package com.abdallahyasser.areacalculator.histroyScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
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

@Preview
@Composable
fun ItemCard(){
    val q=Quadrilater(2f,3f,2f,2f,2f,null)
    q.calculateArea()
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
                Text(text = q.area.toString(),
                    fontSize = 32.sp,
                    maxLines = 1,
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(start = 8.dp, end = 8.dp))
                Icon(if(q.note==""){Icons.Default.Add}else{Icons.Default.Create},
                    contentDescription ="",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(0.15f))
            }
            Text(text = "demo note demo note demo note demo note",
                modifier = Modifier.padding(8.dp))
        }

    }

}