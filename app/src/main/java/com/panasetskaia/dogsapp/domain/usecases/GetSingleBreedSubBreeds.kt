package com.panasetskaia.dogsapp.domain.usecases

import com.panasetskaia.dogsapp.domain.DogRepository
import javax.inject.Inject

class GetSingleBreedSubBreeds @Inject constructor(private val repo: DogRepository) {

    suspend operator fun invoke(breed: String): List<String>? {
        return repo.getSingleBreedSubBreeds(breed)
    }

}