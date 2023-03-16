package com.panasetskaia.dogsapp.domain

interface DogRepository {

    suspend fun getAllBreedsWithPics(): List<DogBreed>

    suspend fun getSingleBreedSubBreeds(id: Int): List<String>

    suspend fun getSingleBreedPictures(id: Int): List<String>

}