package com.example.profesoresapp.data.dto

import com.example.profesoresapp.domain.model.Alumno
import com.example.profesoresapp.domain.model.DetallesMateria
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetalleResponse(val detalles: List<DetallesMateria>? = listOf())