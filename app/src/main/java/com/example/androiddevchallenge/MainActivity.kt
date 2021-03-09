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
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.model.Date
import com.example.androiddevchallenge.ui.component.ActionsComponent
import com.example.androiddevchallenge.ui.component.Clock
import com.example.androiddevchallenge.ui.component.DigitsComponent
import com.example.androiddevchallenge.ui.component.TopBar
import com.example.androiddevchallenge.ui.theme.ClockTheme

class MainActivity : AppCompatActivity() {
    private var currentTime = ""
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClockTheme {
                ClockScreen()
            }
        }
    }

    @Composable
    fun ClockScreen() {
        val currentDate = mainViewModel.currentDate.value

        Surface(color = MaterialTheme.colors.background) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                TopBar()
                Clock(currentDate.hour, currentDate.minutes, currentDate.seconds)
                DigitsComponent { clickedNumber: String ->
                    currentTime += clickedNumber
                    val maxValue = if (currentTime.length > 6) 6 else currentTime.length
                    val newDate = currentTime.substring(0, maxValue)
                    mainViewModel.setDate(Date.fromString(newDate))
                }
                ActionsComponent({
                    mainViewModel.stopTimer()
                    currentTime = ""
                }, {
                    mainViewModel.loadTimer()
                })
            }
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
}