package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@Composable
fun ActionsComponent(removeAction: () -> Unit, launchAction: () -> Unit) {
    Row(verticalAlignment = Alignment.Bottom,
        modifier = Modifier.fillMaxHeight().padding(bottom = 32.dp)) {
        val buttonStyle = TextStyle(
            fontSize = 14.sp,
            color = Color.LightGray,
            fontFamily = FontFamily.SansSerif
        )
        Button(onClick = {
            removeAction()
        }) {
            Text(text = "Remove".toUpperCase(Locale.getDefault()), style = buttonStyle)
        }
        Spacer(modifier = Modifier.padding(14.dp))
        Button(onClick = {
            launchAction()
        }) {
            Text(text = "Validate".toUpperCase(Locale.getDefault()), style = buttonStyle)
        }
    }
}