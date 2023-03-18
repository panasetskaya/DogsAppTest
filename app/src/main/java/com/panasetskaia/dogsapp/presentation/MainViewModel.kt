package com.panasetskaia.dogsapp.presentation

import android.text.Editable
import android.util.Log
import androidx.databinding.InverseMethod
import androidx.lifecycle.viewModelScope
import com.panasetskaia.dogsapp.base.BaseViewModel
import com.panasetskaia.dogsapp.domain.GetAllBreedsWithPicsUseCase
import com.panasetskaia.dogsapp.domain.GetSingleBreedPictures
import com.panasetskaia.dogsapp.domain.GetSingleBreedSubBreeds
import com.panasetskaia.dogsapp.presentation.screen_initial.InitialFragmentDirections
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getAllBreedsWithPicsUseCase: GetAllBreedsWithPicsUseCase,
    private val getSingleBreedSubBreeds: GetSingleBreedSubBreeds,
    private val getSingleBreedPictures: GetSingleBreedPictures
) : BaseViewModel() {

    private val _breedsNames = MutableStateFlow<String?>(null)
    val breedsNames: StateFlow<String?> = _breedsNames

    fun goToAllDogsFragmentClicked() {
        navigate(InitialFragmentDirections.actionInitialFragmentToAllDogsFragment())
    }

    fun DUMMYgetSingleBreedSubBreeds() {
        viewModelScope.launch {
            val subBreeds = getSingleBreedSubBreeds("hound")
            _breedsNames.value = subBreeds.toString()
        }
    }

    fun DUMMYgetAllDogs() {
        viewModelScope.launch {
            val allBreeds = getAllBreedsWithPicsUseCase()
            Log.e("MY_TAG", allBreeds.toString())
        }
    }





}