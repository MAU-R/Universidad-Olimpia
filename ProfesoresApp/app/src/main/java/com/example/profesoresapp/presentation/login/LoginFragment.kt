package com.example.profesoresapp.presentation.login

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.profesoresapp.core.extension.failure
import com.example.profesoresapp.core.extension.observe
import com.example.profesoresapp.core.presentation.BaseFragment
import com.example.profesoresapp.core.presentation.BaseViewState
import com.example.profesoresapp.databinding.MateriaFragmentBinding
import com.example.profesoresapp.domain.model.Materia
import com.example.profesoresapp.presentation.materias.MateriaAdapter
import com.example.profesoresapp.presentation.materias.MateriaFragmentDirections
import com.example.profesoresapp.presentation.materias.MateriaViewModel
import com.example.profesoresapp.presentation.materias.MateriaViewState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi
import com.example.profesoresapp.R
import com.example.profesoresapp.databinding.LoginFragmentBinding

@WithFragmentBindings
@AndroidEntryPoint
@DelicateCoroutinesApi
class LoginFragment:  BaseFragment(R.layout.login_fragment) {

    private lateinit var binding: LoginFragmentBinding
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
    }

    override fun onResume() {
        super.onResume()
        loginViewModel
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {

        }
    }



    override fun setBinding(view: View) {
        binding = LoginFragmentBinding.bind(view)

     //   setHasOptionsMenu(true)

        binding.lifecycleOwner = this

        binding.apply {

        }

        baseActivity.setBottomNavVisibility(View.VISIBLE)
    }


}