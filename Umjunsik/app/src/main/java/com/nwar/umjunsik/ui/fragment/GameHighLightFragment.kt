package com.nwar.umjunsik.ui.fragment

import android.os.Bundle
import android.view.View
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.FragmentGameHighLightBinding
import com.nwar.umjunsik.extend.extendFunction.initAdapter
import com.nwar.umjunsik.ui.adapter.GameHighLightAdapter
import com.nwar.umjunsik.ui.base.BaseFragment
import com.nwar.umjunsik.viewModel.viewModel.GameHighLightViewModel
import javax.inject.Inject

class GameHighLightFragment : BaseFragment<FragmentGameHighLightBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_game_high_light
    @Inject
    override lateinit var viewModel: GameHighLightViewModel

    override fun setViewModel() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainHighlightRecyclerview.initAdapter(GameHighLightAdapter(this, viewModel))
    }
}
