package com.panasetskaia.dogsapp.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DogApiByBreedResponse(
    @SerializedName("message")
    @Expose
    val message: ArrayList<String>,

    @SerializedName("status")
    @Expose
    val status: String
)
