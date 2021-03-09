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
package com.ludovic.vimont.composetimer

import kotlinx.coroutines.delay

class MainRepository(private val timerListener: TimerListener) {
    companion object {
        const val ONE_SECOND_MS: Long = 1_000
    }

    interface TimerListener {
        fun onTick(remainingTimeInMs: Long)
    }

    suspend fun launchTimer(timeInMs: Long) {
        var remainingTimeInMS = timeInMs
        val totalOfSeconds = timeInMs / ONE_SECOND_MS
        for (second in totalOfSeconds downTo 1) {
            remainingTimeInMS -= ONE_SECOND_MS
            timerListener.onTick(remainingTimeInMS)
            delay(ONE_SECOND_MS)
        }
    }
}
