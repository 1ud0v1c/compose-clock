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
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.fillMaxHeight().padding(bottom = 32.dp)
    ) {
        val buttonStyle = TextStyle(
            fontSize = 14.sp,
            color = Color.LightGray,
            fontFamily = FontFamily.SansSerif
        )
        Button(
            onClick = {
                removeAction()
            }
        ) {
            Text(text = "Remove".toUpperCase(Locale.getDefault()), style = buttonStyle)
        }
        Spacer(modifier = Modifier.padding(14.dp))
        Button(
            onClick = {
                launchAction()
            }
        ) {
            Text(text = "Validate".toUpperCase(Locale.getDefault()), style = buttonStyle)
        }
    }
}
