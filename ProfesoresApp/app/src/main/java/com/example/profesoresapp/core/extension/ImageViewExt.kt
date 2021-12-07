package com.example.profesoresapp.core.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.example.profesoresapp.R

@BindingAdapter("loadFromURLCircular")
fun ImageView.loadFromURLCircular(url: String?) = url?.let {
    this.load(url) {
        crossfade(true)
        placeholder(R.drawable.ic_school)
        error(R.drawable.ic_school)
        transformations(CircleCropTransformation())
    }
}

@BindingAdapter("loadFromURL")
fun ImageView.loadFromURL(url: String?) = url?.let {
    this.load(url) {
        crossfade(true)
        placeholder(R.drawable.ic_school)
        error(R.drawable.ic_school)
    }
}