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
    private var currentJob: Job? = null
    private val date = Date(0,0,30)
    private val mainRepository: MainRepository = MainRepository(this)
    val currentDate: MutableState<Date> = mutableStateOf(date)

    fun loadTimer() {
        currentJob = viewModelScope.launch(Dispatchers.Default) {
            mainRepository.launchTimer(date.toMs())
        }
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

    fun stopTimer() {
        currentJob?.cancel()
        currentDate.value = date
    }
}