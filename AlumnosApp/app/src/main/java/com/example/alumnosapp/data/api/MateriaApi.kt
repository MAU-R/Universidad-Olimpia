package com.example.alumnosapp.data.api

import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.data.dto.MaestrosResponse
import com.example.alumnosapp.data.dto.MateriasResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MateriaApi {

    @GET("get/materia/")
    fun getMateriaById(@Query("id") id:Int) : Call<MateriasResponse>


    //Esta es solo para el use case
    @GET("")
    fun getMateriasByName(@Query("id") name: String): Call<MateriasResponse>

}