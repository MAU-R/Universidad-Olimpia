package com.example.alumnosapp.presentation.alumno

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.alumnosapp.R
import com.example.alumnosapp.core.extension.failure
import com.example.alumnosapp.core.extension.observe
import com.example.alumnosapp.core.presentation.BaseFragment
import com.example.alumnosapp.core.presentation.BaseViewState
import com.example.alumnosapp.databinding.MateriaFragmentBinding
import com.example.alumnosapp.domain.model.Materia
import com.example.alumnosapp.presentation.materias.MateriaAdapter
import com.example.alumnosapp.presentation.materias.MateriaViewModel
import com.example.alumnosapp.presentation.materias.MateriaViewState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

