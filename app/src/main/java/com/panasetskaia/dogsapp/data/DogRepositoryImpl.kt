package com.panasetskaia.dogsapp.data

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.panasetskaia.dogsapp.domain.DogBreed
import com.panasetskaia.dogsapp.domain.DogRepository
import javax.inject.Inject

class DogRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): DogRepository {

    private val currentBreedList = mutableListOf<DogBreed>()

    override suspend fun getAllBreedsWithPics(): List<DogBreed> {
        val responseJson = apiService.getAllBreedsNames().message
        val breeds = responseJson.keySet()
        val gson = Gson()
        val typeToken = object : TypeToken<List<String>>() {}.type
        breeds.forEach {
            val subBreedsJsonArray = responseJson.getAsJsonArray(it)
            val subBreeds = gson.fromJson<List<String>>(subBreedsJsonArray,typeToken)
            val pics = getSingleBreedSubBreeds(it) ?: listOf()
            val breed = DogBreed(it, subBreeds, pics)
            currentBreedList.add(breed)
        }
        return currentBreedList
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
