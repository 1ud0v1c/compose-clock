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
package com.ludovic.vimont.composetimer.model

import com.ludovic.vimont.composetimer.utils.get

data class Date(
    val hour: Int,
    val minutes: Int,
    val seconds: Int
) {
    companion object {
        fun fromString(stringDate: String): Date {
            val length = stringDate.length
            val hour = "${stringDate.get(length - 6, "0")}${stringDate.get(length - 5, "0")}"
            val minute = "${stringDate.get(length - 4, "0")}${stringDate.get(length - 3, "0")}"
            val second = "${stringDate.get(length - 2, "0")}${stringDate.get(length - 1, "0")}"
            return Date(hour.toInt(), minute.toInt(), second.toInt())
        }
    }

    fun toMs(): Long {
        return hour.toLong() * 60 * 60 * 1_000 +
            minutes.toLong() * 60 * 1_000 +
            seconds.toLong() * 1_000
    }
}
