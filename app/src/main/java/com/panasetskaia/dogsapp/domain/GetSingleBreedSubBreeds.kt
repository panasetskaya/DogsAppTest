package com.panasetskaia.dogsapp.domain

import javax.inject.Inject

class GetSingleBreedSubBreeds @Inject constructor(private val repo: DogRepository) {

    suspend operator fun invoke(breed: String): List<String>? {
        return repo.getSingleBreedSubBreeds(breed)
    }

}