package com.panasetskaia.dogsapp.domain.usecases

import com.panasetskaia.dogsapp.domain.DogBreed
import com.panasetskaia.dogsapp.domain.DogRepository
import javax.inject.Inject

class GetAllBreedsWithPicsUseCase @Inject constructor(private val repo: DogRepository) {

    suspend operator fun invoke(): List<DogBreed>? {
        return repo.getAllBreedsWithPics()
    }

}