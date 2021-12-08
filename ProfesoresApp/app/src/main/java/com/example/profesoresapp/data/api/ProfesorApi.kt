package com.example.profesoresapp.data.api

import com.example.profesoresapp.data.dto.ProfesoresResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfesorApi {

    @GET("")
    fun getProfesoresByName(@Query("s") name: String): Call<ProfesoresResponse>

}