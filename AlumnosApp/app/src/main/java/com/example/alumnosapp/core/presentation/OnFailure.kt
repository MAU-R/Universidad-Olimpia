package com.example.alumnosapp.core.presentation

import com.example.alumnosapp.core.exception.Failure

interface OnFailure {

    fun handleFailure(failure: Failure?)

}