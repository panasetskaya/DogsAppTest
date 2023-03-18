package com.panasetskaia.dogsapp.domain

import javax.inject.Inject

class GetSingleBreedPictures @Inject constructor(private val repo: DogRepository) {

    suspend operator fun invoke(breed: String): List<String>? {
        return repo.getSingleBreedPictures(breed)
    }
}