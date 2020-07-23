package com.nwar.umjunsik.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.navigation.ui.NavigationUI
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.FragmentNewsFeedBinding
import com.nwar.umjunsik.ui.adapter.NewsFeedAdapter
import com.nwar.umjunsik.ui.base.BaseFragment
import com.nwar.umjunsik.viewModel.viewModel.NewsFeedViewModel
import javax.inject.Inject

class NewsFeedFragment : BaseFragment<FragmentNewsFeedBinding>() {
    @Inject
    lateinit var parent : MainFragment
    override val layoutId: Int
        get() = R.layout.fragment_news_feed
    @Inject
    override lateinit var viewModel : NewsFeedViewModel

    override fun setViewModel() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavUI()
        initRecyclerView()
    }

    private fun initNavUI() {
        NavigationUI.setupWithNavController(binding.newsfeedNavigationDrawer, parent.navController)
        binding.mainNewsfeedNavDrawerBtn.setOnClickListener { openOrCloseDrawer() }
    }

    private fun initRecyclerView() {
        binding.mainNewsfeedRecyclerView.baseAdapter = NewsFeedAdapter(this@NewsFeedFragment, viewModel)
    }

    private fun openOrCloseDrawer() {
        if(binding.newsfeedDrawerlayout.isDrawerOpen(GravityCompat.START)) {
            binding.newsfeedDrawerlayout.closeDrawer(GravityCompat.START)
        } else {
            binding.newsfeedDrawerlayout.openDrawer(GravityCompat.START)
        }
    }
}
