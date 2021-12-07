package com.example.profesoresapp.core.presentation

import com.example.profesoresapp.core.exception.Failure

interface OnFailure {

    fun handleFailure(failure: Failure?)

}