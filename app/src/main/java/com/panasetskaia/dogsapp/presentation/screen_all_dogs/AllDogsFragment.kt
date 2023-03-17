package com.panasetskaia.dogsapp.presentation.screen_all_dogs

import android.content.Context
import android.os.Bundle
import com.panasetskaia.dogsapp.R
import com.panasetskaia.dogsapp.base.BaseFragment
import com.panasetskaia.dogsapp.databinding.FragmentAllDogsBinding
import com.panasetskaia.dogsapp.presentation.MainViewModel
import com.panasetskaia.utils.getAppComponent
import javax.inject.Inject

class AllDogsFragment: BaseFragment<FragmentAllDogsBinding, MainViewModel>() {

    override val layoutId: Int = R.layout.fragment_all_dogs

    @Inject
    override lateinit var viewModel: MainViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getAppComponent().inject(this)
    }

    override fun onReady(savedInstanceState: Bundle?) {
        //todo
    }

}