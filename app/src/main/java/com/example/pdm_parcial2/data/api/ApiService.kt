package com.rankeuca.data.api

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object ApiClient {
    private const val BASE_URL = "https://qjcxdvfzyseuvezacxsd.supabase.co/functions/v1/rankeuca"
    private const val API_KEY = "4dc8f785-8f2d-4911-a4a5-0fda9fd9317c"

    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
        defaultRequest {
            url(BASE_URL)
            headers.append(HttpHeaders.Authorization, "Bearer $API_KEY")
            headers.append(HttpHeaders.ContentType, ContentType.Application.Json)
        }
    }
}