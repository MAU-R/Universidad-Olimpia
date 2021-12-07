package com.example.alumnosapp.data.dto

import com.example.alumnosapp.domain.model.Alumno
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlumnosResponse(val alumnos: List<Alumno>? = listOf())