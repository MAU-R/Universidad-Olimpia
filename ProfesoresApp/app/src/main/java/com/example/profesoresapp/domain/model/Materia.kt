package com.example.profesoresapp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
class Materia(
    val idMateria: Int = 0,
    @Json(name = "") val name: String = "",
    @Json(name = "") val foto: String = "",
    @Json(name = "") val afgh: String = "",
    @Json(name = "") val a: String = "",
    @Json(name = "") val c: String = ""
) {
}