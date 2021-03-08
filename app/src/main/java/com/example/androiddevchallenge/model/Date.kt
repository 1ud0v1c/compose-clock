package com.example.androiddevchallenge.model

data class Date(val hour: Int,
                val minutes: Int,
                val seconds: Int) {
    fun toMs(): Long {
        return hour.toLong() * 60 * 60 * 1_000 +
               minutes.toLong() * 60 * 1_000 +
               seconds.toLong() * 1_000
    }
}