package com.example.androiddevchallenge

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