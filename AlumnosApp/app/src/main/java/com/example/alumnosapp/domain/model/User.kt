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
class User(
    @PrimaryKey(autoGenerate = false)
    val idUser: Int = 0,
    @Json(name = "") val name: String = "",
    @Json(name = "") val foto: String = "",
    @Json(name = "") val correo: String = "",
    @Json(name = "") val contraseña: String = ""
): Parcelable {
}