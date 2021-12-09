package com.example.alumnosapp.presentation.login

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.alumnosapp.R
import com.example.alumnosapp.core.extension.failure
import com.example.alumnosapp.core.extension.observe
import com.example.alumnosapp.core.presentation.BaseFragment
import com.example.alumnosapp.core.presentation.BaseViewState
import com.example.alumnosapp.databinding.LoginFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

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
            is LoginViewState.LoggedUser->
                navController.navigate(LoginFragmentDirections.actionLoginFragmentToAccountFragment())
        }
    }



    override fun setBinding(view: View) {
        binding = LoginFragmentBinding.bind(view)

        //   setHasOptionsMenu(true)

        binding.lifecycleOwner = this

        binding.apply {
            lifecycleOwner= this@LoginFragment
            btnDoLogin.setOnClickListener { loginViewModel.doLogin(edtMatricula.text.toString().toInt(), edtPassword.text.toString()) }
        }

        baseActivity.setBottomNavVisibility(View.VISIBLE)
    }


}