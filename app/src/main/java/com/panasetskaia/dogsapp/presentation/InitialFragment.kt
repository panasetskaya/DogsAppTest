package com.panasetskaia.dogsapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.panasetskaia.dogsapp.R

class InitialFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_initial, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            InitialFragment()
    }
}