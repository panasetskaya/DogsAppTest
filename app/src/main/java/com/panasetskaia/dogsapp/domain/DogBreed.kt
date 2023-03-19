package com.panasetskaia.dogsapp.domain

import androidx.databinding.BaseObservable

data class DogBreed(
    val name: String,
    val pictures: List<String>,
    val subBreeds: List<String>
): BaseObservable()
