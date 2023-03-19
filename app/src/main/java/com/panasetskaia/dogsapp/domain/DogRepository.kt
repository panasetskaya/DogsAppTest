package com.panasetskaia.dogsapp.domain

interface DogRepository {

    suspend fun getAllBreedsWithPics(): List<DogBreed>?

    suspend fun getSingleBreedSubBreeds(breed: String): List<String>?

    suspend fun getSingleSubBreedRandomPicture(breed: String, subBreed: String): String?

    suspend fun getSingleBreedRandomPicture(breed: String): String?

}