package com.example.profesoresapp.data.dto

import com.example.profesoresapp.domain.model.Profesor
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProfesoresResponse(val profesores: List<Profesor>? = listOf())