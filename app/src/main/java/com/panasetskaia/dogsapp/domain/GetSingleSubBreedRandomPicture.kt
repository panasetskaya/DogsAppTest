package com.panasetskaia.dogsapp.domain

import javax.inject.Inject

class GetSingleSubBreedRandomPicture @Inject constructor(private val repo: DogRepository) {

    suspend operator fun invoke(breed: String, subBreed: String): String? {
        return repo.getSingleSubBreedRandomPicture(breed, subBreed)
    }
}