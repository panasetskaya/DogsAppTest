package com.panasetskaia.dogsapp.presentation.screen_initial

import android.content.Context
import android.os.Bundle
import com.panasetskaia.dogsapp.R
import com.panasetskaia.dogsapp.presentation.base.BaseFragment
import com.panasetskaia.dogsapp.databinding.FragmentInitialBinding
import com.panasetskaia.dogsapp.presentation.MainViewModel
import com.panasetskaia.dogsapp.utils.getAppComponent
import javax.inject.Inject

class InitialFragment :
    BaseFragment<FragmentInitialBinding, MainViewModel>() {

    override val layoutId: Int = R.layout.fragment_initial

    @Inject
    override lateinit var viewModel: MainViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getAppComponent().inject(this)
    }

    override fun onReady(savedInstanceState: Bundle?) {
        binding.viewModel = viewModel
        with(binding.dogAnimationView) {
            repeatCount = 0
            playAnimation()
        }
    }
}