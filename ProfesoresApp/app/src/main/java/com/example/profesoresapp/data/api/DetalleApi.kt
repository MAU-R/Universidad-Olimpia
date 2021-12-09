package com.example.profesoresapp.data.api

import com.example.profesoresapp.data.dto.AlumnosResponse
import com.example.profesoresapp.data.dto.DetalleResponse
import com.example.profesoresapp.data.dto.MateriasResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DetalleApi {
    /*
    *  fun getMateriasPorProfesor(Id: Int):Either<Failure, List<Materia>>
    fun getAlumnosPorMateria(id:Int):Either<Failure,List<Alumno>>
    fun getDetalleMateria(id:Int):Either<Failure, DetallesMateria>
    * */
    @GET("/get/materias/maestro/")
    fun getMateriasPorProfesor(@Query("id")id:Int): Call<MateriasResponse>
    @GET("get/alumnos/")
    fun getAlumnosPorMateria(@Query("id")id:Int): Call<AlumnosResponse>
    @GET("get/detalle/maestro/{id}/{ida}")
    fun getDetalleMateria(@Query("id") id: Int, @Query("ida")ida:Int): Call<DetalleResponse>
}