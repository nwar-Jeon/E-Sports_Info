package com.nwar.umjunsik.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.FragmentGameLiveBinding
import com.nwar.umjunsik.extend.extendProperty.baseAdapter
import com.nwar.umjunsik.ui.adapter.GameLiveChattingAdapter
import com.nwar.umjunsik.ui.base.BaseFragment
import com.nwar.umjunsik.ui.base.BaseViewModel
import com.nwar.umjunsik.viewModel.viewModel.GameLiveViewModel
import javax.inject.Inject

class GameLiveFragment() : BaseFragment<FragmentGameLiveBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_game_live
    @Inject
    override lateinit var viewModel: GameLiveViewModel

    override fun setViewModel() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    fun initRecyclerView() {
        binding.mainLiveRecyclerView.baseAdapter = GameLiveChattingAdapter(this, viewModel)
    }
}