package com.example.profesoresapp.data.dto

import com.example.profesoresapp.domain.model.Materia
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MateriasResponse(val materias: List<Materia>? = listOf())