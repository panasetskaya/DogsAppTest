package com.panasetskaia.dogsapp.data

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.panasetskaia.dogsapp.domain.DogBreed
import com.panasetskaia.dogsapp.domain.DogRepository
import javax.inject.Inject

class DogRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : DogRepository {

    private var currentBreedList: MutableList<DogBreed>? = null

    override suspend fun getAllBreedsWithPics(): List<DogBreed>? {
        val response = apiService.getAllBreedsNames()
        if (response.status == STATUS_SUCCESS) {
            currentBreedList = mutableListOf()
            val responseJson = response.message
            parseJson(responseJson)
        }
        return currentBreedList
    }

    override suspend fun getSingleBreedSubBreeds(breed: String): List<String>? {
        val response = apiService.getSubBreedsByBreed(breed)
        val message = returnListIfSuccess(response)
        if (message is List<*>) {
            return message
        }
        return returnListIfSuccess(response)
    }

    private suspend fun getSingleBreedPictures(breed: String): List<String>? {
        val response = apiService.getImagesByBreed(breed)
        return returnListIfSuccess(response)
    }

    override suspend fun getSingleSubBreedPictures(breed: String, subBreed: String): List<String>? {
        val response = apiService.getImagesBySubBreed(breed, subBreed)
        return returnListIfSuccess(response)
    }

    private fun returnListIfSuccess(response: DogApiByBreedResponse): List<String>? {
        return if (response.status == STATUS_SUCCESS) {
            response.message
        } else null
    }

    private suspend fun parseJson(jsonObject: JsonObject) {
        val breeds = jsonObject.keySet()
        val gson = Gson()
        val typeToken = object : TypeToken<List<String>>() {}.type
        breeds.forEach {
            val subBreedsJsonArray = jsonObject.getAsJsonArray(it)
            val subBreeds = gson.fromJson<List<String>>(subBreedsJsonArray, typeToken)
            val pics = getSingleBreedPictures(it) ?: listOf()
            val breed = DogBreed(it, pics, subBreeds)
            currentBreedList?.add(breed)
        }
    }

    companion object {
        private const val STATUS_SUCCESS = "success"
    }
}
