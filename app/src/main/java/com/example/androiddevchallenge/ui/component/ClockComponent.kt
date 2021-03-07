package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun Clock(hour: Int = 9,
          minutes: Int = 0,
          seconds: Int = 0) {
    Row(modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        Text(text = String.format("%02d", hour),
            style = typography.h1)
        Text(text = ":",
            modifier = Modifier.padding(4.dp))
        Text(text = String.format("%02d", minutes),
            style = typography.h1)
        Text(text = ":",
            modifier = Modifier.padding(4.dp))
        Text(text = String.format("%02d", seconds),
            style = typography.h1)
    }
}