package com.example.alumnosapp.presentation.alumno

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.alumnosapp.R
import com.example.alumnosapp.core.extension.failure
import com.example.alumnosapp.core.extension.observe
import com.example.alumnosapp.core.presentation.BaseFragment
import com.example.alumnosapp.core.presentation.BaseViewState
import com.example.alumnosapp.databinding.AccountFragmentBinding
import com.example.alumnosapp.presentation.login.LoginFragmentDirections
import com.example.alumnosapp.presentation.login.LoginViewState

class CuentaFragment :  BaseFragment(R.layout.account_fragment) {

    private lateinit var binding: AccountFragmentBinding
    private val loginViewModel by viewModels<CuentaViewModel>()

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
        binding = AccountFragmentBinding.bind(view)

        //   setHasOptionsMenu(true)

        binding.lifecycleOwner = this

        binding.apply {
            lifecycleOwner= this@CuentaFragment

        }

        baseActivity.setBottomNavVisibility(View.VISIBLE)
    }
}
