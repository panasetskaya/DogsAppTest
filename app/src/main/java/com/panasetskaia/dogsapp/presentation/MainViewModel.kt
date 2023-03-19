package com.panasetskaia.dogsapp.presentation

import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.viewModelScope
import com.panasetskaia.dogsapp.base.BaseViewModel
import com.panasetskaia.dogsapp.domain.*
import com.panasetskaia.dogsapp.presentation.screen_all_dogs.AllDogsFragmentDirections
import com.panasetskaia.dogsapp.presentation.screen_initial.InitialFragmentDirections
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getAllBreedsWithPicsUseCase: GetAllBreedsWithPicsUseCase,
    private val getSingleBreedSubBreeds: GetSingleBreedSubBreeds,
    private val getSingleSubBreedRandomPicture: GetSingleSubBreedRandomPicture,
    private val getSingleBreedRandomPicture: GetSingleBreedRandomPicture
) : BaseViewModel() {

    private val _allDogs = MutableStateFlow<NetworkResult<List<DogBreed>>>(NetworkResult.loading())
    val allDogs: StateFlow<NetworkResult<List<DogBreed>>> = _allDogs

    private val _breedName = MutableStateFlow<String?>(null)
    val breedNameFlow: StateFlow<String?> = _breedName

    private val _singlePicUrl = MutableStateFlow<String?>(null)
    val singlePictureFlow: StateFlow<String?> = _singlePicUrl

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _subBreedsFlow = MutableStateFlow<ArrayList<String>?>(null)
    val subBreedsFlow: StateFlow<ArrayList<String>?> = _subBreedsFlow

    val spinnerPos = MutableStateFlow<Int?>(null)

    val clicksListener =  object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            if (breedNameFlow.value!=null && subBreedsFlow.value!=null) {
                viewModelScope.launch {
                    val subBreed = subBreedsFlow.value!![position]
                    val url = getSingleSubBreedRandomPicture(breedNameFlow.value!!, subBreed)
                    _singlePicUrl.value = url
                }
            }
        }
    }

    fun goToAllDogsFragmentClicked() {
        navigate(InitialFragmentDirections.actionInitialFragmentToAllDogsFragment())
    }

    fun goToDetailsFragmentClicked(breed: String) {
        viewModelScope.launch {
            navigate(AllDogsFragmentDirections.actionAllDogsFragmentToDogDetailsFragment(breed))
        }
    }

    fun getAnotherRandomPicByBreed() {
        viewModelScope.launch{
            breedNameFlow.value?.let {
                val url = getSingleBreedRandomPicture(it)
                _singlePicUrl.value = url
            }
        }

    }

    fun changeCurrentBreed(breed: String) {
        _breedName.value = breed
        viewModelScope.launch {
            val url = getSingleBreedRandomPicture(breed)
            _singlePicUrl.value = url
            val subBreeds = getSingleBreedSubBreeds(breed)
            _subBreedsFlow.value = subBreeds as ArrayList<String>?
            subBreeds?.let {
                spinnerPos.value = it.size-1
            }

        }
    }

    fun getAllDogBreeds() {
        viewModelScope.launch {
            _isLoading.value = true
            val breedsList = getAllBreedsWithPicsUseCase()
            if (breedsList != null) {
                _allDogs.value = NetworkResult.success(breedsList)
            } else {
                _allDogs.value = NetworkResult.error()
            }
            _isLoading.value = false
        }
    }
}