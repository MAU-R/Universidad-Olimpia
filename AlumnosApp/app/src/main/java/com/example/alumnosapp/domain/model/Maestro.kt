package com.example.alumnosapp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
class Maestro(
    @Json(name="matricula")  val idMaestro: Int = 0,
    @Json(name = "nombre") val name: String = "",
    @Json(name = "foto") val foto: String = "",
    @Json(name = "apellido_paterno") val apellidopa: String = "",
    @Json(name = "apellido_materno") val apellidoma: String = "",
    @Json(name = "correo") val correo: String = "",
    @Json(name="contraseña") val password: String =""
) {
}