package com.example.adventofcode2021

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

object ApiUtil {

    suspend fun getInputFromApi(day: Int): List<String> {
        val client = HttpClient()
        val response: HttpResponse = client.get("https://adventofcode.com/2021/day/${day}/input") {
            headers {
                append(
                    HttpHeaders.Cookie,
                    "session=53616c7465645f5f885156dcb4813e1ac5423522c2ae6a213299515d99b430db136cf2c89646e20b3634f95ff9a830e0"
                )
            }
        }
        return response.receive<String>().split("\n")
    }
}