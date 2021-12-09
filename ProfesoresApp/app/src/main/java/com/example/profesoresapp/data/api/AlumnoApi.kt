package com.example.profesoresapp.data.api

import com.example.profesoresapp.data.dto.AlumnosResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlumnoApi {

    @GET("get/alumno/")
    fun getAlumnoById(@Query("id") di:Int) : Call<AlumnosResponse>
}