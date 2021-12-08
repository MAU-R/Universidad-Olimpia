package com.example.alumnosapp.data.api

import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.data.dto.MateriasResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MateriaApi {

    @GET("")
    fun getMateriasByName(@Query("s") name: String): Call<MateriasResponse>

}