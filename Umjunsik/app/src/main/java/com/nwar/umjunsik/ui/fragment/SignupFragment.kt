package com.nwar.umjunsik.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.FragmentSignupBinding
import com.nwar.umjunsik.ui.base.BaseFragment
import com.nwar.umjunsik.viewModel.viewModel.SignupViewModel
import javax.inject.Inject

class SignupFragment() : BaseFragment<FragmentSignupBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_signup
    @Inject
    override lateinit var viewModel: SignupViewModel

    override fun setViewModel() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        duplicateCheckSetBackIfEvent()
    }

    private fun duplicateCheckSetBackIfEvent() {
        viewModel.id.observe(this, Observer { viewModel.isDuplicateId.postValue(null) })
        viewModel.nickName.observe(this, Observer { viewModel.isDuplicateNickName.postValue(null) })
    }
}
