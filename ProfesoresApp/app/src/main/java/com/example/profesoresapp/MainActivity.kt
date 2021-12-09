package com.example.profesoresapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import com.example.profesoresapp.core.presentation.BaseActivity
import com.example.profesoresapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun layoutId()=R.layout.activity_main

    override val fragmentContainer: FragmentContainerView
        get() = binding.mainFragmentContainer

    override fun setUpNavigation(navController: NavController) {
        NavigationUI.setupWithNavController(
            binding.mainBottomNav,
            navController
        )
    }

    override fun showProgress(show: Boolean) {
      //  binding.progressView.isVisible = show
    }

    override fun setBottomNavVisibility(visibility: Int) {

    }

    override fun setBinding() {
        binding = DataBindingUtil.setContentView(this, layoutId())

        binding.apply {
            lifecycleOwner = this@MainActivity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setBinding()
        setBottomNavVisibility(View.VISIBLE)
    }
}