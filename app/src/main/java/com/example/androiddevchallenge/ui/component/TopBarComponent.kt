package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TopBar() {
    TopAppBar(title = {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Compose Clock",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    })
}