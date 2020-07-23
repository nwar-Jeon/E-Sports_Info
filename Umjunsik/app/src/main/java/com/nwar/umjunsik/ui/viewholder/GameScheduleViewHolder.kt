package com.nwar.umjunsik.ui.viewholder

import androidx.databinding.ObservableField
import com.nwar.domain.entity.GameSchedule
import com.nwar.umjunsik.databinding.ItemGameScheduleBinding
import com.nwar.umjunsik.ui.base.BaseViewHolder
import com.nwar.umjunsik.viewModel.viewModel.GameScheduleViewModel

class GameScheduleViewHolder(val binding : ItemGameScheduleBinding, val vm : GameScheduleViewModel) : BaseViewHolder(binding.root) {
    override fun bind(list : List<Any>) {
        binding.vm = vm
        binding.position = index
    }
}