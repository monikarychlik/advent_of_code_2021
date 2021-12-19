package com.example.adventofcode2021.tasks

object Day1 {
    fun task1(input: List<String>): String {
        var result = 0
        input.let {
            for (i in 1 until it.size) {
                if (it[i - 1] < it[i]) {
                    result++
                }
            }
        }
        return result.toString()
    }

    fun task2(input: List<String>): String {
        var result = 0
        input.let {
            for (i in 3 until it.size) {
//                    val firstSum = it[i-3] + it[i-2] + it[i-1]
//                    val secondSum = it[i-2] + it[i-1] + it[i]
                if (it[i - 3] < it[i]) {
                    result++
                }
            }
        }
        return result.toString()
    }
}
