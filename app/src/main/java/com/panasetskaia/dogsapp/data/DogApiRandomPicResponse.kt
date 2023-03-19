package com.panasetskaia.dogsapp.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DogApiRandomPicResponse(
    @SerializedName("message")
    @Expose
    override val message: String,

    @SerializedName("status")
    @Expose
    override val status: String
) : Response()