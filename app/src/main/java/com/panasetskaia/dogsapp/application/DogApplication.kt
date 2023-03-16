package com.panasetskaia.dogsapp.application

import android.app.Application
import com.panasetskaia.dogsapp.di.DaggerAppComponent

class DogApplication: Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }

}