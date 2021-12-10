package com.example.alumnosapp.presentation.detalle

import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.alumnosapp.R
import com.example.alumnosapp.core.presentation.BaseFragment
import com.example.alumnosapp.databinding.DetalleFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings


@AndroidEntryPoint
@WithFragmentBindings
class DetalleFragment : BaseFragment(R.layout.detalle_fragment) {

    private lateinit var binding: DetalleFragmentBinding
    private val args: DetalleFragmentArgs by navArgs()

    override fun setBinding(view: View) {

        binding = DetalleFragmentBinding.bind(view)

        binding.apply {
            lifecycleOwner = this@DetalleFragment
            clase = args.clase
        }

    }
}