package com.panasetskaia.dogsapp.domain

data class Dog(
    val id: Int,
    val name: String,
    val pictures: List<String>,
    val subBreeds: List<String>
)
