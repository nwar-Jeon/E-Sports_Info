package com.nwar.umjunsik.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.FragmentMainBinding
import com.nwar.umjunsik.ui.base.BaseFragment
import com.nwar.umjunsik.viewModel.viewModel.MainViewModel
import javax.inject.Inject


class MainFragment : BaseFragment<FragmentMainBinding>() {

    @Inject
    override lateinit var viewModel : MainViewModel

    override val layoutId: Int
        get() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NavigationUI.setupWithNavController(binding.bottomNavigationView, Navigation.findNavController(view.findViewById(R.id.fragment_navigation_home)))
    }

    override fun setViewModel() {
        binding.vm = viewModel
    }
}
