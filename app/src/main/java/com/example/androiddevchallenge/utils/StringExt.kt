package com.example.androiddevchallenge.utils

fun String.get(index: Int, defaultValue: String): String {
    elementAtOrNull(index)?.let { character: Char ->
        return "$character"
    }
    return defaultValue
}