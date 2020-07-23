package com.nwar.umjunsik.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.FragmentGameScheduleBinding
import com.nwar.umjunsik.extend.extendFunction.initAdapter
import com.nwar.umjunsik.extend.extendProperty.baseAdapter
import com.nwar.umjunsik.ui.adapter.GameScheduleAdapter
import com.nwar.umjunsik.ui.base.BaseFragment
import com.nwar.umjunsik.ui.base.BaseViewModel
import com.nwar.umjunsik.viewModel.viewModel.GameScheduleViewModel
import javax.inject.Inject

class GameScheduleFragment : BaseFragment<FragmentGameScheduleBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_game_schedule
    @Inject
    override lateinit var viewModel: GameScheduleViewModel

    override fun setViewModel() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    fun initRecyclerView() {
        binding.mainScheduleRecyclerView.initAdapter(GameScheduleAdapter(this, viewModel))
    }
}
