package com.example.alumnosapp.core.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.example.alumnosapp.R

@BindingAdapter("loadFromUrl")
fun ImageView.loadFromURL(url: String?) = this.load(url) {
    crossfade(true)
    placeholder(R.drawable.ic_school)
    transformations(CircleCropTransformation())
}