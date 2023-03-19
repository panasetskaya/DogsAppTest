package com.panasetskaia.dogsapp.utils

import androidx.fragment.app.Fragment
import com.panasetskaia.dogsapp.application.DogApplication
import com.panasetskaia.dogsapp.di.AppComponent

fun Fragment.getAppComponent(): AppComponent =
    (requireActivity().application as DogApplication).component

const val MY_LOG_TAG = "my_tag"