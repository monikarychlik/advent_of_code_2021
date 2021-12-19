package com.example.adventofcode2021.tasks

object Day2 {

    fun task1(input: List<String>): String {
        var position = 0
        var depth = 0

        input.forEach {
            val data = it.split(" ")
            if (data.size != 2) {
                return@forEach
            }
            val number = data[1].toInt()

            when (data[0]) {
                "forward" -> position += number
                "down" -> depth += number
                "up" -> depth -= number
            }
        }
        return (position*depth).toString()
    }

    fun task2(input: List<String>): String {
        var position = 0
        var depth = 0
        var aim = 0

        input.forEach {
            val data = it.split(" ")
            if (data.size != 2) {
                return@forEach
            }
            val number = data[1].toInt()

            when (data[0]) {
                "forward" -> {
                    position += number
                    depth += aim*number
                }
                "down" -> aim += number
                "up" -> aim -= number
            }
        }
        return (position*depth).toString()
    }
}