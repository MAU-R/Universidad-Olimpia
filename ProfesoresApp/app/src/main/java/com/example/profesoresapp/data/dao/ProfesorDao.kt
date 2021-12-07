package com.example.profesoresapp.data.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import com.example.profesoresapp.domain.model.Profesor

@Dao
interface ProfesorDao {

    @Query("SELECT * FROM Profesor WHERE name LIKE :filter")
    fun getProfesoresByName(filter: String): List<Profesor>

    @Insert(onConflict = IGNORE)
    fun saveProfesores(profesores: List<Profesor>): List<Long>

    @Update
    fun updateProfesor(profesor: Profesor): Int
}