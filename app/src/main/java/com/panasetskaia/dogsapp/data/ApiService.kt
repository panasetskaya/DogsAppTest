package com.panasetskaia.dogsapp.data

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

    @GET("breed/{breed_name}/{sub_breed_name}/images")
    suspend fun getImagesBySubBreed(
        @Path(
            value = "breed_name",
            encoded = true
        ) breedName: String,
        @Path(
            value = "sub_breed_name",
            encoded = true
        ) subBreedName: String,
    ): DogApiByBreedResponse

}