package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun DigitsComponent(onDigitClick: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth(0.75f).padding(32.dp)) {
        val textStyle = TextStyle(
            fontSize = 30.sp,
            color = Color.Gray
        )
        var number = 0
        for (i in 1..3) {
            Row(modifier = Modifier.fillMaxWidth().padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                for (j in 1..3) {
                    number++
                    val currentNumber = "$number"
                    Button(onClick = {
                        onDigitClick(currentNumber)
                    }) {
                        Text(text = currentNumber, style = textStyle)
                    }
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(onClick = { onDigitClick("0") }) {
                Text(text = "0", style = textStyle)
            }
        }
    }
}