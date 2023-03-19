package com.panasetskaia.dogsapp.presentation.screen_details

import android.content.Context
import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.panasetskaia.dogsapp.R
import com.panasetskaia.dogsapp.presentation.base.BaseFragment
import com.panasetskaia.dogsapp.databinding.FragmentDogDetailsBinding
import com.panasetskaia.dogsapp.presentation.MainViewModel
import com.panasetskaia.dogsapp.utils.getAppComponent
import javax.inject.Inject

class DogDetailsFragment : BaseFragment<FragmentDogDetailsBinding, MainViewModel>() {
    override val layoutId: Int = R.layout.fragment_dog_details

    @Inject
    override lateinit var viewModel: MainViewModel

    private val navArgs by navArgs<DogDetailsFragmentArgs>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getAppComponent().inject(this)
    }

    override fun onReady(savedInstanceState: Bundle?) {
        binding.viewModel = viewModel
        viewModel.changeCurrentBreed(navArgs.breedName)
    }
}