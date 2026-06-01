package com.example.pdm_parcial2.data.api.dto.mapper

import com.example.pdm_parcial2.data.api.dto
import com.rankeuca.domain.model.Place

fun PlaceDto.toDomain() = Place(
    id = id,
    name = name,
    imageUrl = imageUrl,
    votes = votes
)