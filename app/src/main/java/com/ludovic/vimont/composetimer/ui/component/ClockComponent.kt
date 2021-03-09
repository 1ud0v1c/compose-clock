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
package com.ludovic.vimont.composetimer.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun Clock(
    hour: Int = 9,
    minutes: Int = 0,
    seconds: Int = 0
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 32.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = String.format("%02d", hour),
            style = typography.h1
        )
        Text(
            text = ":",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(4.dp),
        )
        Text(
            text = String.format("%02d", minutes),
            style = typography.h1
        )
        Text(
            text = ":",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = String.format("%02d", seconds),
            style = typography.h1
        )
    }
}
