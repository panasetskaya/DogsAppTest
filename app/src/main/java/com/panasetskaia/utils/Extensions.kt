package com.panasetskaia.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import com.panasetskaia.dogsapp.R
import com.panasetskaia.dogsapp.application.DogApplication
import com.panasetskaia.dogsapp.di.AppComponent

fun <T> LiveData<T>.observeNonNull(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(
        owner
    ) {
        it?.let(observer)
    }
}

fun Fragment.getAppComponent(): AppComponent =
    (requireActivity().application as DogApplication).component


@BindingAdapter("imageUrl")
fun setImageUrl(imgView: ImageView, imgUrl: String?) {
    Glide.with(imgView.context).load(imgUrl)
        .placeholder(R.drawable.dog_breed_placeholder)
        .into(imgView)
}
