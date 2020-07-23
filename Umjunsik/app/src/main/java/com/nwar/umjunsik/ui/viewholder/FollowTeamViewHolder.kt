package com.nwar.umjunsik.ui.viewholder

import com.nwar.umjunsik.databinding.ItemTeamFollowBinding
import com.nwar.umjunsik.ui.base.BaseViewHolder
import com.nwar.umjunsik.viewModel.viewModel.TeamFollowViewModel

class FollowTeamViewHolder(val binding : ItemTeamFollowBinding, val vm : TeamFollowViewModel) : BaseViewHolder(binding.root) {
    override fun bind(list : List<Any>) {
        binding.position = index
        binding.vm = vm
    }
}