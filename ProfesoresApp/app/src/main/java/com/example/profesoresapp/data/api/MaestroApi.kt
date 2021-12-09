package com.example.profesoresapp.data.api


import com.example.profesoresapp.data.dto.ProfesoresResponse
import com.example.profesoresapp.domain.model.Alumno
import com.example.profesoresapp.domain.model.Profesor
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MaestroApi {
    @POST("login/maestro")
    fun login(@Body maestro : Profesor) : Call<Profesor>
    @POST("edit/maestro")
    fun updateMaestro(@Body maestro: Profesor): Call<ProfesoresResponse>

}