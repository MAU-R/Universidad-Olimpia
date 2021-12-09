package com.example.profesoresapp.data.dto


import com.example.profesoresapp.domain.model.Alumno
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlumnosResponse(val alumnos: List<Alumno>? = listOf())