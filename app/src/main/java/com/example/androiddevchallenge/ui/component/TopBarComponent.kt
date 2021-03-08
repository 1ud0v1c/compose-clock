package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun TopBar() {
    TopAppBar(title = {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Compose Clock",
                style = TextStyle(color = Color.White, fontSize = 22.sp),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    })
}