package com.example.profesoresapp.data.api

import com.example.profesoresapp.data.dto.MateriasResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MateriaApi {

    @GET("/")
    fun getMateriasByName(@Query("id") name: String): Call<MateriasResponse>
    @GET("/get/materia/")
    fun getMateriaByID(@Query("id")id:Int):Call<MateriasResponse>

}