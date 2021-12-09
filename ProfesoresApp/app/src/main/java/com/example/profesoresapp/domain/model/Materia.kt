package com.example.profesoresapp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
@Parcelize
@JsonClass(generateAdapter = true)
class Materia(
    @Json(name="matricula") val idMateria: Int = 0,
    @Json(name = "nombre") val name: String = "",
    @Json(name = "foto") val foto: String = "",
    @Json(name = "descripcion") val descripcion: String = "",
) : Parcelable{
}