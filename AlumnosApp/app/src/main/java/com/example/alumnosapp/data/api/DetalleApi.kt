package com.example.alumnosapp.data.api

import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.data.dto.DetalleResponse
import com.example.alumnosapp.data.dto.MateriasResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DetalleApi {

    @GET("/get/materias/alumno/")
    fun getMateriasPorAlumno(@Query("id")id:Int): Call<MateriasResponse>

    @GET("get/detalle/alumno/{id}/{ida}")
    fun getDetalleMateria(@Query("id") id: Int, @Query("ida")ida:Int): Call<DetalleResponse>

}