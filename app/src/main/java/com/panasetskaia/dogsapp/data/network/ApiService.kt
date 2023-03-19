package com.panasetskaia.dogsapp.data.network

import com.panasetskaia.dogsapp.data.network.responses.DogApiAllDogsResponse
import com.panasetskaia.dogsapp.data.network.responses.DogApiByBreedResponse
import com.panasetskaia.dogsapp.data.network.responses.DogApiRandomPicResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("breeds/list/all")
    suspend fun getAllBreedsNames(
    ): DogApiAllDogsResponse

    @GET("breed/{breed_name}/images")
    suspend fun getImagesByBreed(
        @Path(
            value = "breed_name",
            encoded = true
        ) breedName: String
    ): DogApiByBreedResponse

    @GET("breed/{breed_name}/list")
    suspend fun getSubBreedsByBreed(
        @Path(
            value = "breed_name",
            encoded = true
        ) breedName: String
    ): DogApiByBreedResponse

    @GET("breed/{breed_name}/images/random")
    suspend fun getRandomPicByBreed(
        @Path(
            value = "breed_name",
            encoded = true
        ) breedName: String
    ): DogApiRandomPicResponse

    @GET("breed/{breed_name}/{sub_breed_name}/images/random")
    suspend fun getRandomPicBySubBreed(
        @Path(
            value = "breed_name",
            encoded = true
        ) breedName: String,
        @Path(
            value = "sub_breed_name",
            encoded = true
        ) subBreedName: String,
    ): DogApiRandomPicResponse

}