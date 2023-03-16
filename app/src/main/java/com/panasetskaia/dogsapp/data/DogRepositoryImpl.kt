package com.panasetskaia.dogsapp.data

import com.panasetskaia.dogsapp.domain.DogBreed
import com.panasetskaia.dogsapp.domain.DogRepository
import javax.inject.Inject

class DogRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): DogRepository {

    override suspend fun getAllBreedsWithPics(): List<DogBreed> {
        TODO("Not yet implemented")
    }

    override suspend fun getSingleBreedSubBreeds(id: Int): List<String> {
        TODO("Not yet implemented")
    }

    override suspend fun getSingleBreedPictures(id: Int): List<String> {
        TODO("Not yet implemented")
    }
}