package com.example.profesoresapp.core.plataform

import android.content.Context
import com.example.profesoresapp.core.extension.networkInfo
import javax.inject.Inject

class NetworkHandler @Inject constructor(private val context: Context) {

    val isConnected get() = context.networkInfo?.isConnectedOrConnecting == true

}