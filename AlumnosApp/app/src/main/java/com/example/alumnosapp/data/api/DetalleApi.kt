package com.example.alumnosapp.data.api

import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.data.dto.DetalleResponse
import com.example.alumnosapp.data.dto.MateriasResponse
import com.example.alumnosapp.domain.model.DetallesMateria
import com.example.alumnosapp.domain.model.Materia
import com.example.alumnosapp.domain.model.TwoIds
import retrofit2.Call
import retrofit2.http.*

interface DetalleApi {

    @GET("get/materias/alumnos/{id}")
    fun getMateriasPorAlumno(@Path("id")id:Int): Call<List<Materia>>

    @POST("get/detalle")
    fun getDetalleMateria(@Body ids: TwoIds): Call<DetallesMateria>
}