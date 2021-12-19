package com.example.adventofcode2021

object SolutionUtil {

    fun getSolution(day: Int, taskNumber: Int, input: List<String>): String {
        val cls = FunctionUtil.getClassByDay(day)
        val kotlinClass = cls.kotlin
        val method = FunctionUtil.getTaskFunctionInClassByNumber(cls, taskNumber)
        return method.invoke(kotlinClass.objectInstance, input)?.toString() ?: ""
    }
}