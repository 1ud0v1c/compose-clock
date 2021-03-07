/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.ClockTheme
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClockTheme {
                ClockScreen()
            }
        }
    }
}

@Composable
fun ClockScreen() {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            TopBar()
            Clock()
        }
    }
}

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

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    ClockTheme {
        ClockScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    ClockTheme(darkTheme = true) {
        ClockScreen()
    }
}