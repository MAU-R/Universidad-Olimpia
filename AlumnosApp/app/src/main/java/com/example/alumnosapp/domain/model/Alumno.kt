package com.example.alumnosapp.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Alumno(
    @Json (name="matricula")  val idAlumno: Int = 0,
    @Json(name = "nombre") var name: String = "",
    @Json(name = "foto") val foto: String = "",
    @Json(name = "apellido_paterno") val apellidopa: String = "",
    @Json(name = "apellido_materno") val apellidoma: String = "",
    @Json(name = "correo") var correo: String = "",
    @Json(name="contraseña") var password: String =""
) {
}