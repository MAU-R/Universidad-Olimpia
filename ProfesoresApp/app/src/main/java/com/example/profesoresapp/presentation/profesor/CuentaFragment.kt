package com.example.profesoresapp.presentation.profesor

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.profesoresapp.R
import com.example.profesoresapp.core.extension.failure
import com.example.profesoresapp.core.extension.observe
import com.example.profesoresapp.core.presentation.BaseFragment
import com.example.profesoresapp.core.presentation.BaseViewState
import com.example.profesoresapp.databinding.CuentaFragmentBinding
import com.example.profesoresapp.databinding.LoginFragmentBinding
import com.example.profesoresapp.domain.model.Profesor
import com.example.profesoresapp.presentation.login.LoginFragmentDirections
import com.example.profesoresapp.presentation.login.LoginViewModel
import com.example.profesoresapp.presentation.login.LoginViewState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
@AndroidEntryPoint
@WithFragmentBindings
class CuentaFragment :  BaseFragment(R.layout.cuenta_fragment) {

    private lateinit var binding: CuentaFragmentBinding
    private val cuentaViewModel by viewModels<CuentaViewModel>()
    private lateinit var loged:Profesor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cuentaViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
    }

    override fun onResume() {
        super.onResume()
        cuentaViewModel.getLocalUser()
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {

            is CuentaViewState.LoggedUser->
            {
                binding.user= state.profesor;
                loged=state.profesor
            }
            is CuentaViewState.UserNotFound->
                navController.navigate(CuentaFragmentDirections.actionCuentaFragmentToLoginFragment2())
        }
    }



    override fun setBinding(view: View) {
        binding = CuentaFragmentBinding.bind(view)

        //   setHasOptionsMenu(true)

        binding.lifecycleOwner = this

        binding.apply {
            lifecycleOwner= this@CuentaFragment
            btnLogout.setOnClickListener {
                cuentaViewModel.logout()
            }
            btnGuardar.setOnClickListener {
                loged.name=txvUsername.text.toString()
                loged.correo=txvcorreo.text.toString()
                loged.contrasena=edtContraseA.text.toString()
                cuentaViewModel.guardar(loged)
                cuentaViewModel.doSaveLocalUser(loged)
                cuentaViewModel.getLocalUser()
            }
        }


    }
}
