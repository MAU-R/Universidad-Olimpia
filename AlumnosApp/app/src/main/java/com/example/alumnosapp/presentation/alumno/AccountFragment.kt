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
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
@AndroidEntryPoint
@WithFragmentBindings
class AccountFragment :  BaseFragment(R.layout.account_fragment) {

    private lateinit var binding: AccountFragmentBinding
    private val accountViewModel by viewModels<AccountViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        accountViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
    }

    override fun onResume() {
        super.onResume()
        accountViewModel.getLocalUser()
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {

            is AccountViewState.LoggedUser->
                binding.user= state.alumno;
            is AccountViewState.UserNotFound->
                navController.navigate(AccountFragmentDirections.actionAccountFragmentToLoginFragment())
        }
    }



    override fun setBinding(view: View) {
        binding = AccountFragmentBinding.bind(view)

        //   setHasOptionsMenu(true)

        binding.lifecycleOwner = this

        binding.apply {
            lifecycleOwner= this@AccountFragment
            btnLogout.setOnClickListener {
                accountViewModel.logout()
            }
        }


    }
}

