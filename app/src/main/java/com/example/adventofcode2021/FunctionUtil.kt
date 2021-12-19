package com.example.adventofcode2021

import java.lang.reflect.Method

object FunctionUtil {

    fun getClassByDay(day: Int): Class<*> {
        val fullClassName = "com.example.adventofcode2021.tasks.Day$day"
        return Class.forName(fullClassName)
    }

    fun getTaskFunctionInClassByNumber(classs: Class<*>, taskNumber: Int): Method {
        return classs.getMethod("task$taskNumber", List::class.java)
    }
}