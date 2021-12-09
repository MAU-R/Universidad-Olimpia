package com.example.alumnosapp.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class DetalleMateria(
    @Json(name="id") var idDetalle:Int=0,
    @Json(name="matricula") var matricula:String="",
    @Json(name="dias") var dias:String="",
    @Json(name="horas") var horas:String="",
    @Json(name="id_alumno") var id_alumno:Int=0,
    @Json(name="id_maestro") var id_maestro:Int=0,
    @Json(name="id_materia") var id_materia:Int=0,
    @Json(name="calificacion_1") var calificacion1:Double=0.0,
    @Json(name="calificacion_2") var calificacion2:Double=0.0,
    @Json(name="calificacion_3") var calificacion3:Double=0.0,
    @Json(name="concluido") var concluido:Boolean=false
) {

}