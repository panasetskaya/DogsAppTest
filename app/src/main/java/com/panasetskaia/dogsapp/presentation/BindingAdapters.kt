package com.panasetskaia.dogsapp.presentation

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.panasetskaia.dogsapp.R

@BindingAdapter("imageUrl")
fun setImageUrl(imgView: ImageView, imgUrl: String?) {
    Glide.with(imgView.context).load(imgUrl)
        .placeholder(R.drawable.pic_drawable_placeholder)
        .into(imgView)
}