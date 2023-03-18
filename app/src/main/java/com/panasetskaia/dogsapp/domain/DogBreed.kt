package com.panasetskaia.dogsapp.domain

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.panasetskaia.dogsapp.R

data class DogBreed(
    val name: String,
    val pictures: List<String>,
    val subBreeds: List<String>
)
