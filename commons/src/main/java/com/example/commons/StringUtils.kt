package com.example.commons

import java.util.*

class StringUtils {
    companion object{
        fun String.capital(): String {
            return this.trim().split("\\s+".toRegex())
                .map { word -> word.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() } }.joinToString(" ")
        }
    }

}