package com.panasetskaia.dogsapp.presentation.screen_all_dogs

import android.app.Activity
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.panasetskaia.dogsapp.R
import com.panasetskaia.dogsapp.domain.DogBreed
import com.panasetskaia.dogsapp.presentation.base.NetworkResult
import com.panasetskaia.dogsapp.presentation.base.Status
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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

@BindingAdapter("app:submittedData")
fun bindData(recyclerView: RecyclerView, data: StateFlow<NetworkResult<List<DogBreed>>>) {
    val adapter = recyclerView.adapter as BreedsAdapter
    adapter.lifecycleOwner.lifecycleScope.launch {
        adapter.lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            data.collectLatest {
                when (it.status) {
                    Status.SUCCESS -> {
                        adapter.submitList(it.data)
                    }
                    Status.ERROR -> {
                        Toast.makeText(
                            adapter.lifecycleOwner as Activity,
                            R.string.network_mistake,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Status.LOADING -> {

                    }
                }
            }
        }
    }
}