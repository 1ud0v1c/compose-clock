package com.example.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.model.Date
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class MainViewModel: ViewModel(), MainRepository.TimerListener {
    private val mainRepository: MainRepository = MainRepository(this)
    private val mutableDate = MutableLiveData<Date>()
    val currentDate: LiveData<Date> = mutableDate

    fun loadTimer(timeInMs: Long = 60 * 1_000) {
        viewModelScope.launch(Dispatchers.Default) {
            mainRepository.launchTimer(timeInMs)
        }
    }

    override fun onTick(remainingTimeInMs: Long) {
        val remainingMinute = TimeUnit.MILLISECONDS.toMinutes(remainingTimeInMs)
        val currentTime = Date(
            TimeUnit.MILLISECONDS.toHours(remainingTimeInMs).toInt(),
            remainingMinute.toInt(),
            (TimeUnit.MILLISECONDS.toSeconds(remainingTimeInMs) - TimeUnit.MINUTES.toSeconds(remainingMinute)).toInt()
        )
        mutableDate.postValue(currentTime)
    }
}