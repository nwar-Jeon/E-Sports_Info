package com.nwar.umjunsik.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.FragmentSigninBinding
import com.nwar.umjunsik.ui.base.BaseFragment
import com.nwar.umjunsik.ui.base.BaseViewModel
import com.nwar.umjunsik.viewModel.viewModel.SignInViewModel
import javax.inject.Inject

class SigninFragment : BaseFragment<FragmentSigninBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_signin
    @Inject
    override lateinit var viewModel : SignInViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.nextFragmentAction.observe(this, Observer {
            if(it!=null) if(navController.currentDestination?.getAction(it)!=null)navigate(it)
        })
    }

    override fun setViewModel() {
        binding.vm = viewModel
    }
}
