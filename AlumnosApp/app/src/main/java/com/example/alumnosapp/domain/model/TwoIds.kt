package com.example.alumnosapp.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class TwoIds(
    @Json(name="id_materia")val id_materia:Int,
   @Json(name="id_usuario") val id_alumno:Int
) {
}