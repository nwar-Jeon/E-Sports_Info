package com.nwar.umjunsik.ui.viewholder

import com.nwar.umjunsik.databinding.ItemLiveChattingBinding
import com.nwar.umjunsik.ui.base.BaseViewHolder
import com.nwar.umjunsik.viewModel.viewModel.GameLiveViewModel

class GameLiveChattingViewHolder(val binding : ItemLiveChattingBinding, val vm : GameLiveViewModel) : BaseViewHolder(binding.root) {
    override fun bind(list : List<Any>) {
        binding.vm = vm
        binding.position = index
    }
}