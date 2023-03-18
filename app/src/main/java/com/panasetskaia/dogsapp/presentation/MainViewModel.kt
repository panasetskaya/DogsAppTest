package com.panasetskaia.dogsapp.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.panasetskaia.dogsapp.base.BaseViewModel
import com.panasetskaia.dogsapp.domain.DogBreed
import com.panasetskaia.dogsapp.domain.GetAllBreedsWithPicsUseCase
import com.panasetskaia.dogsapp.domain.GetSingleSubBreedPictures
import com.panasetskaia.dogsapp.domain.GetSingleBreedSubBreeds
import com.panasetskaia.dogsapp.presentation.screen_all_dogs.AllDogsFragmentDirections
import com.panasetskaia.dogsapp.presentation.screen_initial.InitialFragmentDirections
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getAllBreedsWithPicsUseCase: GetAllBreedsWithPicsUseCase,
    private val getSingleBreedSubBreeds: GetSingleBreedSubBreeds,
    private val getSingleSubBreedPictures: GetSingleSubBreedPictures
) : BaseViewModel() {

    private val _allDogs = MutableStateFlow<NetworkResult<List<DogBreed>>>(NetworkResult.loading())
    val allDogs: StateFlow<NetworkResult<List<DogBreed>>> = _allDogs

    private val _breedName = MutableStateFlow<String?>(null)
    val breedNameFlow: StateFlow<String?> = _breedName

    fun goToAllDogsFragmentClicked() {
        navigate(InitialFragmentDirections.actionInitialFragmentToAllDogsFragment())
    }

    fun goToDetailsFragmentClicked(breed: String) {
        viewModelScope.launch {
            _breedName.value = breed
            navigate(AllDogsFragmentDirections.actionAllDogsFragmentToDogDetailsFragment())
        }
    }

    fun getAllDogBreeds() {
        viewModelScope.launch {
            val breedsList = getAllBreedsWithPicsUseCase()
            if (breedsList!=null) {
                _allDogs.value = NetworkResult.success(breedsList)
            } else {
                _allDogs.value = NetworkResult.error()
            }
        }
    }



//    fun DUMMYgetSingleBreedSubBreeds() {
//        viewModelScope.launch {
//            val subBreeds = getSingleBreedSubBreeds("hound")
//            _breedsNames.value = subBreeds.toString()
//        }
//    }
}