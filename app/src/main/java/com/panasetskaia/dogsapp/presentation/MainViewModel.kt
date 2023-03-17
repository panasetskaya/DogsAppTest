package com.panasetskaia.dogsapp.presentation

import com.panasetskaia.dogsapp.base.BaseViewModel
import com.panasetskaia.dogsapp.domain.GetAllBreedsWithPicsUseCase
import com.panasetskaia.dogsapp.domain.GetSingleBreedPictures
import com.panasetskaia.dogsapp.domain.GetSingleBreedSubBreeds
import com.panasetskaia.dogsapp.presentation.screen_initial.InitialFragmentDirections
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getAllBreedsWithPicsUseCase: GetAllBreedsWithPicsUseCase,
    private val getSingleBreedSubBreeds: GetSingleBreedSubBreeds,
    private val getSingleBreedPictures: GetSingleBreedPictures
) : BaseViewModel() {

    fun goToAllDogsFragmentClicked() {
        navigate(InitialFragmentDirections.actionInitialFragmentToAllDogsFragment())
    }

}