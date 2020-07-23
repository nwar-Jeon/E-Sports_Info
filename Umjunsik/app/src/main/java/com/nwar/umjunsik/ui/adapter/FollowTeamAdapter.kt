package com.nwar.umjunsik.ui.adapter

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.ItemTeamFollowBinding
import com.nwar.umjunsik.ui.base.BaseAdapter
import com.nwar.umjunsik.ui.base.BaseViewHolder
import com.nwar.umjunsik.ui.viewholder.FollowTeamViewHolder
import com.nwar.umjunsik.viewModel.viewModel.TeamFollowViewModel

class FollowTeamAdapter(fragment : Fragment, val vm : TeamFollowViewModel) : BaseAdapter(fragment.context!!, fragment) {
    override fun createViewHolder(binding: ViewDataBinding): BaseViewHolder = FollowTeamViewHolder(binding as ItemTeamFollowBinding, vm)

    override fun getLayoutId(viewType: Int): Int = R.layout.item_team_follow

    override fun getItemCount(): Int = itemList.size
}