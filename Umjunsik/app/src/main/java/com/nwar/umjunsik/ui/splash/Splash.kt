package com.nwar.umjunsik.ui.splash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.FragmentMainBinding
import com.nwar.umjunsik.databinding.FragmentSplashBinding
import com.nwar.umjunsik.ui.base.BaseFragment
import com.nwar.umjunsik.ui.base.BaseViewModel
import com.nwar.umjunsik.viewModel.viewModel.SplashViewModel

class Splash : BaseFragment<FragmentSplashBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_splash

    override val viewModel by lazy { SplashViewModel() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.nextFragmentAction.observe(this, Observer {
            navigate(it)
        })
    }

    fun toSignInFragment() {
        navigate(R.id.action_splash_to_signinFragment)
    }

    fun toMainFragment() {
        navigate(R.id.action_splash_to_mainFragment)
    }

    override fun setViewModel() {
        binding.vm = viewModel
    }
}
