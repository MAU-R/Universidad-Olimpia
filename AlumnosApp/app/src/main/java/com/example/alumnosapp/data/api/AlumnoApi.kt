package com.example.alumnosapp.data.api

import com.example.alumnosapp.data.dto.AlumnosResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlumnoApi {
    @GET("")
    fun getAlumnosByName(@Query("s") name: String): Call<AlumnosResponse>
}