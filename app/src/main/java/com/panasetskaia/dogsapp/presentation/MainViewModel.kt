package com.panasetskaia.dogsapp.presentation

import androidx.lifecycle.ViewModel
import com.panasetskaia.dogsapp.domain.GetAllBreedsWithPicsUseCase
import com.panasetskaia.dogsapp.domain.GetSingleBreedPictures
import com.panasetskaia.dogsapp.domain.GetSingleBreedSubBreeds
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getAllBreedsWithPicsUseCase: GetAllBreedsWithPicsUseCase,
    private val getSingleBreedSubBreeds: GetSingleBreedSubBreeds,
    private val getSingleBreedPictures: GetSingleBreedPictures
): ViewModel() {
}