package com.nwar.umjunsik.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.FragmentChangeNicknameBinding
import com.nwar.umjunsik.ui.base.BaseFragment
import com.nwar.umjunsik.util.BackNavigator
import com.nwar.umjunsik.viewModel.viewModel.ChangeNicknameViewModel
import javax.inject.Inject

class ChangeNicknameFragment() : BaseFragment<FragmentChangeNicknameBinding>(), BackNavigator {
    override val layoutId: Int
        get() = R.layout.fragment_change_nickname

    @Inject
    override lateinit var viewModel : ChangeNicknameViewModel

    override fun setViewModel() {
        binding.vm = viewModel
    }

    override fun backNavigate() {
        navController.navigateUp()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.backNavigateUpListener.observe(this, Observer { if(it) backNavigate() })
    }
}
