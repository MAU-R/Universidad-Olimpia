package com.example.profesoresapp.presentation.profesor

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.profesoresapp.R
import com.example.profesoresapp.core.extension.failure
import com.example.profesoresapp.core.extension.observe
import com.example.profesoresapp.core.presentation.BaseFragment
import com.example.profesoresapp.core.presentation.BaseViewState
import com.example.profesoresapp.databinding.CuentaFragmentBinding
import com.example.profesoresapp.databinding.LoginFragmentBinding
import com.example.profesoresapp.presentation.login.LoginFragmentDirections
import com.example.profesoresapp.presentation.login.LoginViewModel
import com.example.profesoresapp.presentation.login.LoginViewState

class CuentaFragment :  BaseFragment(R.layout.cuenta_fragment) {

    private lateinit var binding: CuentaFragmentBinding
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
                navController.navigate(LoginFragmentDirections.actionLoginFragment2ToCuentaFragment())
        }
    }



    override fun setBinding(view: View) {
        binding = CuentaFragmentBinding.bind(view)

        //   setHasOptionsMenu(true)

        binding.lifecycleOwner = this

        binding.apply {
            lifecycleOwner= this@CuentaFragment

        }

        baseActivity.setBottomNavVisibility(View.VISIBLE)
    }
}
