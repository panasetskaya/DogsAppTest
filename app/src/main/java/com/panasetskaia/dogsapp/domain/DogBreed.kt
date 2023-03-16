package com.panasetskaia.dogsapp.domain

data class DogBreed(
    val id: Int,
    val name: String,
    val pictures: List<String>,
    val subBreeds: List<String>
)
