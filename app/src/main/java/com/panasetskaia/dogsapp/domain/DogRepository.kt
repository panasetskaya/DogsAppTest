package com.panasetskaia.dogsapp.domain

interface DogRepository {

    suspend fun getAllBreedsWithPics(): List<DogBreed>?

    suspend fun getSingleBreedSubBreeds(breed: String): List<String>?

    suspend fun getSingleBreedPictures(breed: String): List<String>?

    suspend fun getSingleSubBreedPictures(breed: String, subBreed: String): List<String>?

}