package com.example.alumnosapp.data.api

import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.domain.model.Alumno
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AlumnoApi {

    @POST("login/alumno")
    fun login(@Body alumno : Alumno) : Call<Alumno>

    @POST("edit/alumno")
    fun updateAlumno(@Body alumno: Alumno): Call<AlumnosResponse>
}