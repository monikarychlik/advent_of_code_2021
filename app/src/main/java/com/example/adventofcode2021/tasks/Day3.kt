package com.example.adventofcode2021.tasks

object Day3 {

    fun task1(input: List<String>): String {
        val onesCount = IntArray(input[0].length)
        var gammaRate = ""
        var epsilonRate = ""

        for (j in input[0].indices) {
            for (element in input) {
                val charArray = element.toCharArray()
                if (charArray.isNotEmpty() && charArray[j] == '1') {
                    onesCount[j]++
                }
            }
            if (onesCount[j] < (input.size/2)) {
                gammaRate += "0"
                epsilonRate += "1"
            } else {
                gammaRate += "1"
                epsilonRate += "0"
            }
        }
        return (Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2)).toString()
    }

    fun task2(input: List<String>): String {
        val oxy = getValue(
            input = input,
            moreOnesDefaultValue = "1",
            lessOnesDefaultValue = "0"
        )
        val co2 = getValue(
            input = input,
            moreOnesDefaultValue = "0",
            lessOnesDefaultValue = "1"
        )

        return (Integer.parseInt(oxy, 2) * Integer.parseInt(co2, 2)).toString()
    }

    private fun getValue(
        input: List<String>,
        moreOnesDefaultValue: String,
        lessOnesDefaultValue: String
    ): String {
        var filteredInput = input.toMutableList()
        var filter = ""
        var i = 0

        while (i < filteredInput[0].length && filteredInput.size > 1) {
            filter += getFilterValue(
                input = filteredInput,
                column = i,
                moreOnesDefaultValue = moreOnesDefaultValue,
                lessOnesDefaultValue = lessOnesDefaultValue
            )
            filteredInput = filteredInput.filter {
                it.startsWith(filter)
            }.toMutableList()
            i++
        }
        return filteredInput.first()
    }

    private fun getFilterValue(
        input: List<String>,
        column: Int,
        lessOnesDefaultValue: String,
        moreOnesDefaultValue: String
    ): String {
        var onesCount = 0
        for (element in input) {
            val charArray = element.toCharArray()
            if (charArray.isNotEmpty() && charArray[column] == '1') {
                onesCount++
            }
        }
        return if (onesCount < (input.size / 2f)) {
            lessOnesDefaultValue
        } else {
            moreOnesDefaultValue
        }
    }
}