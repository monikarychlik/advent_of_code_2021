package com.example.adventofcode2021

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

object Main {

    private const val DAY = 3
    private const val TASK_NUMBER = 2

    @RequiresApi(Build.VERSION_CODES.N)
    @JvmStatic
    fun main(args: Array<String>) {
        runBlocking {
            launch {
                val solution = SolutionUtil.getSolution(
                    day = DAY,
                    taskNumber = TASK_NUMBER,
                    input = ApiUtil.getInputFromApi(DAY)
                )
                println(solution)
            }
        }
    }
}