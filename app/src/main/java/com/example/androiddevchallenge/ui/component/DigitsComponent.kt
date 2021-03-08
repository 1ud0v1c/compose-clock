package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun DigitsComponent() {
    Column(modifier = Modifier.fillMaxWidth(0.75f).padding(32.dp)) {
        var number = 0
        for (i in 1..3) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                for (j in 1..3) {
                    number++
                    Text(text = "$number", style = typography.h2)
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Text(text = "0", style = typography.h2)
        }
    }
}