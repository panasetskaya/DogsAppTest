package com.panasetskaia.dogsapp.data.network.responses

abstract class Response {
    abstract val message: Any
    abstract val status: String
}