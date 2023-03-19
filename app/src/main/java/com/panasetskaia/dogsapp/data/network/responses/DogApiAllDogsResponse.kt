package com.panasetskaia.dogsapp.data.network.responses

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DogApiAllDogsResponse(
    @SerializedName("message")
    @Expose
    override val message: JsonObject,

    @SerializedName("status")
    @Expose
    override val status: String
): Response()
