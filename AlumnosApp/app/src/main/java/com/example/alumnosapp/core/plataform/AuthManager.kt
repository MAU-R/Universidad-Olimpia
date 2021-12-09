package com.example.alumnosapp.core.plataform

import android.content.Context
import android.content.SharedPreferences
import com.example.alumnosapp.domain.model.Alumno
import com.squareup.moshi.Moshi
import java.lang.Exception
import javax.inject.Inject

class AuthManager @Inject constructor(private val context: Context){

    private val PrefsKey= "PREFS"
    private val UserKey= "usuario"

    private var preferences: SharedPreferences = context.getSharedPreferences(PrefsKey, Context.MODE_PRIVATE)
    private val moshi = Moshi.Builder().build()

    var usuario: Alumno?
        set(value)= preferences.edit().putString(UserKey, moshi.adapter(Alumno::class.java).toJson(value)).apply()
        get()=preferences.getString(UserKey, null)?.let {
            return@let try {
                moshi.adapter(Alumno::class.java).fromJson(it)
            } catch (e: Exception) {
                null
            }
        }
}