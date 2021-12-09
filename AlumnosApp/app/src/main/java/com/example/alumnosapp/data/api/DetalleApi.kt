package com.example.alumnosapp.data.api

import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.data.dto.DetalleResponse
import com.example.alumnosapp.data.dto.MateriasResponse
import com.example.alumnosapp.domain.model.Materia
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetalleApi {

    @GET("get/materias/alumno/{id}")
    fun getMateriasPorAlumno(@Path("id")id:Int): Call<List<Materia>>

    @GET("get/detalle/alumno/{id}/{ida}")
    fun getDetalleMateria(@Path("id") id: Int, @Path("ida")ida:Int): Call<DetalleResponse>
}