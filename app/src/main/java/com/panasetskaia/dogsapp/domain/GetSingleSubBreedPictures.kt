package com.panasetskaia.dogsapp.domain

import javax.inject.Inject

class GetSingleSubBreedPictures @Inject constructor(private val repo: DogRepository) {

    suspend operator fun invoke(breed: String, subBreed: String): List<String>? {
        return repo.getSingleSubBreedPictures(breed, subBreed)
    }
}