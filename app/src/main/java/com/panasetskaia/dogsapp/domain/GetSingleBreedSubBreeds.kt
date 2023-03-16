package com.panasetskaia.dogsapp.domain

import javax.inject.Inject

class GetSingleBreedSubBreeds @Inject constructor(private val repo: DogRepository) {

    suspend operator fun invoke(id: Int): List<String> {
        return repo.getSingleBreedSubBreeds(id)
    }

}