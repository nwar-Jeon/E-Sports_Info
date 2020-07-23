package com.nwar.umjunsik.ui.viewholder

import com.nwar.umjunsik.databinding.ItemHighlightBinding
import com.nwar.umjunsik.ui.base.BaseViewHolder
import com.nwar.umjunsik.viewModel.viewModel.GameHighLightViewModel

class GameHighLightViewHolder(val binding : ItemHighlightBinding, val vm : GameHighLightViewModel) : BaseViewHolder(binding.root) {
    override fun bind(list: List<Any>) {
        binding.position = index
        binding.vm = vm
    }
}