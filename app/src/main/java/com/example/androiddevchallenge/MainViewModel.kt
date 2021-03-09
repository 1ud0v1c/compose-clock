package com.example.androiddevchallenge

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.model.Date
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class MainViewModel: ViewModel(), MainRepository.TimerListener {
    companion object {
        private val defaultDate = Date(0,0,0)
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