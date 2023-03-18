package com.panasetskaia.dogsapp.presentation.screen_all_dogs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.panasetskaia.dogsapp.R
import com.panasetskaia.dogsapp.databinding.ItemDogBreedCardBinding
import com.panasetskaia.dogsapp.domain.DogBreed

class BreedsAdapter(private val lifecycleOwner: LifecycleOwner): ListAdapter<DogBreed, BreedsAdapter.BreedViewHolder>(BreedsDiffUtil()) {

    var onItemClickListener: ((DogBreed) -> Unit)? = null

    class BreedViewHolder(val binding: ItemDogBreedCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemDogBreedCardBinding>(inflater, R.layout.item_dog_breed_card, parent, false)
        binding.lifecycleOwner = lifecycleOwner
        return BreedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.dogBreed = item
        holder.binding.root.setOnClickListener {
            onItemClickListener?.invoke(item)
            true
        }
    }

}