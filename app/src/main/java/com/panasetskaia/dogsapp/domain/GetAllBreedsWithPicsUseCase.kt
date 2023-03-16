package com.panasetskaia.dogsapp.domain

import javax.inject.Inject

class GetAllBreedsWithPicsUseCase @Inject constructor(private val repo: DogRepository) {

    suspend operator fun invoke(): List<DogBreed> {
        return repo.getAllBreedsWithPics()
    }

}