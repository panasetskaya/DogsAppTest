package com.panasetskaia.dogsapp.domain

import javax.inject.Inject

class GetSingleBreedPictures @Inject constructor(private val repo: DogRepository) {

    suspend operator fun invoke(id: Int): List<String> {
        return repo.getSingleBreedPictures(id)
    }
}