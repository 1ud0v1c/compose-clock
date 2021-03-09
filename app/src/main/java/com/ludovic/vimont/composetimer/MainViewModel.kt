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

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ludovic.vimont.composetimer.model.Date
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class MainViewModel : ViewModel(), MainRepository.TimerListener {
    companion object {
        private val defaultDate = Date(0, 0, 0)
    }
    private var currentJob: Job? = null
    private var date = defaultDate
    private val mainRepository: MainRepository = MainRepository(this)
    val currentDate: MutableState<Date> = mutableStateOf(date)

    fun loadTimer() {
        val isInProgress = currentJob?.isActive ?: false
        if (!isInProgress) {
            currentJob = viewModelScope.launch(Dispatchers.Default) {
                mainRepository.launchTimer(date.toMs())
            }
        }
    }

    fun stopTimer() {
        currentJob?.cancel()
        date = defaultDate
        currentDate.value = date
    }

    fun setDate(newDate: Date) {
        date = newDate
        currentDate.value = newDate
    }

    override fun onTick(remainingTimeInMs: Long) {
        val remainingMinute = TimeUnit.MILLISECONDS.toMinutes(remainingTimeInMs)
        val currentTime = Date(
            TimeUnit.MILLISECONDS.toHours(remainingTimeInMs).toInt(),
            remainingMinute.toInt(),
            (TimeUnit.MILLISECONDS.toSeconds(remainingTimeInMs) - TimeUnit.MINUTES.toSeconds(remainingMinute)).toInt()
        )
        currentDate.value = currentTime
    }
}
