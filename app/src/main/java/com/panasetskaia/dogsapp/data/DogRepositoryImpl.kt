package com.panasetskaia.dogsapp.data

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.panasetskaia.dogsapp.data.network.ApiService
import com.panasetskaia.dogsapp.data.network.responses.Response
import com.panasetskaia.dogsapp.domain.DogBreed
import com.panasetskaia.dogsapp.domain.DogRepository
import com.panasetskaia.dogsapp.utils.MY_LOG_TAG
import javax.inject.Inject

class DogRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : DogRepository {

    private var currentBreedList: MutableList<DogBreed>? = null

    override suspend fun getAllBreedsWithPics(): List<DogBreed>? {
        if (currentBreedList == null) {
            try {
                val response = apiService.getAllBreedsNames()
                if (response.status == STATUS_SUCCESS) {
                    currentBreedList = mutableListOf()
                    val responseJson = response.message
                    parseJson(responseJson)
                }
            } catch (e: Exception) {
                Log.e(MY_LOG_TAG, "${e.message}")
            }
        }
        return currentBreedList
    }

    override suspend fun getSingleBreedSubBreeds(breed: String): List<String>? {
        val result = returnIfSuccess(apiService.getSubBreedsByBreed(breed))
        return if (result is List<*>) result as List<String> else null
    }

    override suspend fun getSingleSubBreedRandomPicture(breed: String, subBreed: String): String? {
        val result = returnIfSuccess(apiService.getRandomPicBySubBreed(breed,subBreed))
        return if (result is String) result else null
    }

    override suspend fun getSingleBreedRandomPicture(breed: String): String? {
        val result = returnIfSuccess(apiService.getRandomPicByBreed(breed))
        return if (result is String) result else null
    }

    private suspend fun getSingleBreedPictures(breed: String): List<String>? {
        val result = returnIfSuccess(apiService.getImagesByBreed(breed))
        return if (result is List<*>) result as List<String> else null
    }

    private fun returnIfSuccess(response: Response): Any? {
        return try {
            if (response.status == STATUS_SUCCESS) {
                response.message
            } else null
        } catch (e: Exception) {
            Log.e(MY_LOG_TAG, "${e.message}")
            null
        }
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
