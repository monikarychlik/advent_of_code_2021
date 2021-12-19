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

    fun task2(input2: List<String>): String {
        val input = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )

        val onesCount = IntArray(input[0].length)
        var oxyFilter = ""
        var co2Filter = ""

        for (i in input[0].indices) {
            for (element in input) {
                val charArray = element.toCharArray()
                if (charArray.isNotEmpty() && charArray[i] == '1') {
                    onesCount[i]++
                }
            }
            if (onesCount[i] < (input.size/2)) {
                oxyFilter += "0"
                co2Filter += "1"
            } else {
                oxyFilter += "1"
                co2Filter += "0"
            }
        }

        var oxy: String?
        var i = 0
        do {
            oxy = input.firstOrNull {
                it.startsWith(oxyFilter.dropLast(i))
            }
            i++
        } while (oxy == null)

        var co2: String?
        i = 0
        do {
            co2 = input.firstOrNull {
                it.startsWith(co2Filter.dropLast(i))
            }
            i++
        } while (co2 == null)

        return (Integer.parseInt(oxy, 2) * Integer.parseInt(co2, 2)).toString()
    }
}