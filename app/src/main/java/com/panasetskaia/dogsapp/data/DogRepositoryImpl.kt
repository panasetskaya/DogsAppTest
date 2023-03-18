package com.panasetskaia.dogsapp.data

import com.google.gson.JsonObject
import com.panasetskaia.dogsapp.domain.DogBreed
import com.panasetskaia.dogsapp.domain.DogRepository
import javax.inject.Inject

class DogRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): DogRepository {

    override suspend fun getAllBreedsWithPics(): List<DogBreed> {
        val responseJson = apiService.getAllBreedsNames().message
        return listOf()
        //todo: implement here
    }

    override suspend fun getSingleBreedSubBreeds(breed: String): List<String>? {
        val response = apiService.getSubBreedsByBreed(breed)
        return returnIfSuccess(response)
    }

    override suspend fun getSingleBreedPictures(breed: String): List<String>? {
        val response = apiService.getImagesByBreed(breed)
        return returnIfSuccess(response)
    }

    override suspend fun getSingleSubBreedPictures(breed: String, subBreed: String): List<String>? {
        val response = apiService.getImagesBySubBreed(breed,subBreed)
        return returnIfSuccess(response)
    }

    private fun returnIfSuccess(response: DogApiByBreedResponse): List<String>? {
        return if (response.status==STATUS_SUCCESS) {
            response.message
        } else null
    }

    private fun parseJson(json: JsonObject) {

    }

    companion object {
        private const val STATUS_SUCCESS = "success"
    }
}
