package com.example.profesoresapp.data.api

import com.example.profesoresapp.data.dto.AlumnosResponse
import com.example.profesoresapp.data.dto.DetalleResponse
import com.example.profesoresapp.data.dto.MateriasResponse
import com.example.profesoresapp.domain.model.Alumno
import com.example.profesoresapp.domain.model.Materia
import retrofit2.Call
import retrofit2.http.*

interface DetalleApi {
    /*
    *  fun getMateriasPorProfesor(Id: Int):Either<Failure, List<Materia>>
    fun getAlumnosPorMateria(id:Int):Either<Failure,List<Alumno>>
    fun getDetalleMateria(id:Int):Either<Failure, DetallesMateria>
    * */
    @GET("get/materias/maestro/{id}")
    fun getMateriasPorProfesor(@Path("id")id:Int): Call<List<Materia>>
    @GET("get/alumnos/{id}")
    fun getAlumnosPorMateria(@Path("id") id:String): Call<List<Alumno>>
    @GET("get/detalle/maestro/{id}/{ida}")
    fun getDetalleMateria(@Path("id") id: Int, @Path("ida")ida:Int): Call<DetalleResponse>
}