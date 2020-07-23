package com.nwar.umjunsik.ui.viewholder

import com.nwar.domain.entity.NewsFeed
import com.nwar.umjunsik.databinding.ItemNewsfeedBinding
import com.nwar.umjunsik.ui.base.BaseViewHolder
import com.nwar.umjunsik.viewModel.viewModel.NewsFeedViewModel

class NewsFeedViewHolder(val binding : ItemNewsfeedBinding, val vm : NewsFeedViewModel) : BaseViewHolder(binding.root) {
    override fun bind(list : List<Any>) {
        binding.position = index
        binding.vm = vm
    }
}