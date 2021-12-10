package com.example.profesoresapp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
@Parcelize
@JsonClass(generateAdapter = true)
class Profesor(
    @Json (name="matricula")  val idProfesor: Int? = 0,
    @Json(name = "nombre") var name: String? = "",
    @Json(name = "foto") val foto: String? = "",
    @Json(name = "apellido_paterno") val apellidopa: String? = "",
    @Json(name = "apellido_materno") val apellidoma: String? = "",
    @Json(name = "correo") var correo: String? = "",
    @Json(name="contraseña") var contrasena: String? =""
):Parcelable {
}