package com.example.androiddevchallenge.model

import com.example.androiddevchallenge.utils.get

data class Date(val hour: Int,
                val minutes: Int,
                val seconds: Int) {
    companion object {
        fun fromString(stringDate: String): Date {
            val length = stringDate.length
            val hour = "${stringDate.get(length-6, "0")}${stringDate.get(length-5, "0")}"
            val minute = "${stringDate.get(length-4, "0")}${stringDate.get(length-3, "0")}"
            val second = "${stringDate.get(length-2, "0")}${stringDate.get(length-1, "0")}"
            return Date(hour.toInt(), minute.toInt(), second.toInt())
        }
    }

    fun toMs(): Long {
        return hour.toLong() * 60 * 60 * 1_000 +
               minutes.toLong() * 60 * 1_000 +
               seconds.toLong() * 1_000
    }
}