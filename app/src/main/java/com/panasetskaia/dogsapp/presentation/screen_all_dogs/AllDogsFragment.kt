package com.panasetskaia.dogsapp.presentation.screen_all_dogs

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.panasetskaia.dogsapp.R
import com.panasetskaia.dogsapp.presentation.base.BaseFragment
import com.panasetskaia.dogsapp.databinding.FragmentAllDogsBinding
import com.panasetskaia.dogsapp.presentation.MainViewModel
import com.panasetskaia.dogsapp.presentation.base.Status
import com.panasetskaia.utils.MY_LOG_TAG
import com.panasetskaia.utils.getAppComponent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class AllDogsFragment : BaseFragment<FragmentAllDogsBinding, MainViewModel>() {

    override val layoutId: Int = R.layout.fragment_all_dogs

    @Inject
    override lateinit var viewModel: MainViewModel

    lateinit var breedAdapter: BreedsAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getAppComponent().inject(this)
    }

    override fun onReady(savedInstanceState: Bundle?) {
        viewModel.getAllDogBreeds()
        breedAdapter = BreedsAdapter(requireActivity())
        binding.recyclerViewDogs.adapter = breedAdapter
        binding.viewModel = viewModel
        breedAdapter.onItemClickListener = {
            viewModel.goToDetailsFragmentClicked(it.name)
            Log.e(MY_LOG_TAG, "goToDetailsFragmentClicked with breed: ${it.name}")
        }
        collectFlow()
    }

    private fun collectFlow() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.allDogs.collectLatest {
                    when (it.status) {
                        Status.SUCCESS -> {
                            breedAdapter.submitList(it.data)
                        }
                        Status.ERROR -> {
                            Toast.makeText(requireActivity(), R.string.network_mistake, Toast.LENGTH_SHORT).show()
                        }
                        Status.LOADING ->{

                        }
                    }

                }
            }
        }
    }

}