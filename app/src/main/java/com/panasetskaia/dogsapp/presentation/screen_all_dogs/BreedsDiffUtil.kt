package com.panasetskaia.dogsapp.presentation.screen_all_dogs

import androidx.recyclerview.widget.DiffUtil
import com.panasetskaia.dogsapp.domain.DogBreed

class BreedsDiffUtil: DiffUtil.ItemCallback<DogBreed>() {
    override fun areItemsTheSame(oldItem: DogBreed, newItem: DogBreed): Boolean {
        return oldItem.name==newItem.name
    }

    override fun areContentsTheSame(oldItem: DogBreed, newItem: DogBreed): Boolean {
        return oldItem == newItem
    }
}