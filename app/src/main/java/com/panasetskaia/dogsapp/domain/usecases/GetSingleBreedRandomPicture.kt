package com.panasetskaia.dogsapp.domain.usecases

import com.panasetskaia.dogsapp.domain.DogRepository
import javax.inject.Inject

class GetSingleBreedRandomPicture  @Inject constructor(private val repo: DogRepository) {

    suspend operator fun invoke(breed: String): String? {
        return repo.getSingleBreedRandomPicture(breed)
    }
}