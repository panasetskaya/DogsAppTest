package com.panasetskaia.dogsapp.presentation.screen_all_dogs

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.panasetskaia.dogsapp.R
import kotlinx.coroutines.flow.MutableStateFlow

@BindingAdapter("app:mSpanCount")
fun RecyclerView.bindSpanCount(
    oldIntFlow: MutableStateFlow<Int>?,
    intFlow: MutableStateFlow<Int>
) {
    val spanCount = intFlow.value
    (layoutManager as GridLayoutManager).spanCount = spanCount
}

@BindingAdapter("imageUrl")
fun setImageUrl(imgView: ImageView, imgUrl: String?) {
    Glide.with(imgView.context).load(imgUrl)
        .placeholder(R.drawable.pic_drawable_placeholder)
        .into(imgView)
}