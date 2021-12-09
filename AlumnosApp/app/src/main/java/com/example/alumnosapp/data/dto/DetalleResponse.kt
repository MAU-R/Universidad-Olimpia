package com.example.alumnosapp.data.dto

import com.example.alumnosapp.domain.model.Alumno
import com.example.alumnosapp.domain.model.DetallesMateria
import com.example.alumnosapp.domain.model.Materia
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetalleResponse(val detalles: List<DetallesMateria>? = listOf())