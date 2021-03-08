package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ActionsComponent(removeAction: () -> Unit, launchAction: () -> Unit) {
    Row {
        Button(onClick = {
            removeAction()
        }) {
            Text(text = "Remove")
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = {
            launchAction()
        }) {
            Text(text = "Validate")
        }
    }
}