package com.nwar.umjunsik.ui.adapter

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.ItemLiveChattingBinding
import com.nwar.umjunsik.ui.base.BaseAdapter
import com.nwar.umjunsik.ui.base.BaseViewHolder
import com.nwar.umjunsik.ui.viewholder.GameLiveChattingViewHolder
import com.nwar.umjunsik.viewModel.viewModel.GameLiveViewModel

class GameLiveChattingAdapter(fragment : Fragment, val vm : GameLiveViewModel) : BaseAdapter(fragment.context!!, fragment) {
    override fun createViewHolder(binding: ViewDataBinding): BaseViewHolder = GameLiveChattingViewHolder(binding as ItemLiveChattingBinding, vm)

    override fun getLayoutId(viewType: Int): Int = R.layout.item_live_chatting

    override fun getItemCount(): Int = itemList.size
}