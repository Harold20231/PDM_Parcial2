package com.example.pdm_parcial2.data.api

import com.example.pdm_parcial2.data.api.dto.VoteRequestDto
import com.example.pdm_parcial2.data.api.dto.PlaceDto
import com.example.pdm_parcial2.data.api.dto.VoteResponseDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpStatusCode

class RankeUcaApi {
    private val client = ApiClient.client

    suspend fun getPlaces(): List<PlaceDto> {
        return try {
            client.get("/places").body()
        } catch (e: Exception) {
            emptyList()
        }
    }

    suspend fun vote(placeId: String): Boolean {
        return try {
            val response = client.post("/vote") {
                setBody(VoteRequestDto(placeId))
            }
            response.status == HttpStatusCode.OK
        } catch (e: Exception) {
            false
        }
    }
}