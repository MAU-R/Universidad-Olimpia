package com.example.alumnosapp.data.api

import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.data.dto.MaestrosResponse
import com.example.alumnosapp.domain.model.Maestro
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MaestroApi {

    @GET("get/maestro/")
    fun getMaestroById(@Query("id") id:Int) : Call<Maestro>
}