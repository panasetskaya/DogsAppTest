package com.panasetskaia.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.panasetskaia.dogsapp.application.DogApplication
import com.panasetskaia.dogsapp.di.AppComponent

fun <T> LiveData<T>.observeNonNull(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(
        owner
    ) {
        it?.let(observer)
    }
}

fun Fragment.getAppComponent(): AppComponent = (requireActivity().application as DogApplication).component