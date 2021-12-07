package com.example.alumnosapp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
@Entity
class Alumno(
    @PrimaryKey(autoGenerate = false)
    val idAlumno: Int = 0,
    @Json(name = "") val name: String = "",
    @Json(name = "") val foto: String = "",
    @Json(name = "") val apellidopa: String = "",
    @Json(name = "") val apellidoma: String = "",
    @Json(name = "") val correo: String = ""
): Parcelable {
}