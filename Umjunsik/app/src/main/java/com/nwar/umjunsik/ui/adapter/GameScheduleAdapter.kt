package com.nwar.umjunsik.ui.adapter

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.ItemGameScheduleBinding
import com.nwar.umjunsik.ui.base.BaseAdapter
import com.nwar.umjunsik.ui.base.BaseViewHolder
import com.nwar.umjunsik.ui.viewholder.GameScheduleViewHolder
import com.nwar.umjunsik.viewModel.viewModel.GameScheduleViewModel

class GameScheduleAdapter(fragment : Fragment, val vm : GameScheduleViewModel) : BaseAdapter(fragment.context!!, fragment) {

    override fun getItemCount(): Int = itemList.size

    override fun getLayoutId(viewType: Int): Int = R.layout.item_game_schedule

    override fun createViewHolder(binding: ViewDataBinding): BaseViewHolder =
        GameScheduleViewHolder(binding as ItemGameScheduleBinding, vm)
}