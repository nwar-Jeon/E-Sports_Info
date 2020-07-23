package com.nwar.umjunsik.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.FragmentTeamFollowBinding
import com.nwar.umjunsik.extend.extendFunction.initAdapter
import com.nwar.umjunsik.extend.extendProperty.baseAdapter
import com.nwar.umjunsik.ui.adapter.FollowTeamAdapter
import com.nwar.umjunsik.ui.base.BaseFragment
import com.nwar.umjunsik.ui.base.BaseViewModel
import com.nwar.umjunsik.util.BackNavigator
import com.nwar.umjunsik.viewModel.viewModel.TeamFollowViewModel
import javax.inject.Inject

class TeamFollowFragment : BaseFragment<FragmentTeamFollowBinding>(), BackNavigator {
    override val layoutId: Int
        get() = R.layout.fragment_team_follow
    @Inject
    override lateinit var viewModel : TeamFollowViewModel

    override fun setViewModel() {
        binding.vm = viewModel
    }

    override fun backNavigate() {
        navController.navigateUp()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.backNavigator.observe(this, Observer { if(it) backNavigate() })
        initRecyclerView()
    }

    fun initRecyclerView() { binding.followTeamRecyclerView.baseAdapter = FollowTeamAdapter(this, viewModel) }
}
