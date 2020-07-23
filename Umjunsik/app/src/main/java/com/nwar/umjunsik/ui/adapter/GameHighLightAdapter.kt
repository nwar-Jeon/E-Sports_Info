package com.nwar.umjunsik.ui.adapter

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.ItemHighlightBinding
import com.nwar.umjunsik.ui.base.BaseAdapter
import com.nwar.umjunsik.ui.base.BaseViewHolder
import com.nwar.umjunsik.ui.viewholder.GameHighLightViewHolder
import com.nwar.umjunsik.viewModel.viewModel.GameHighLightViewModel

class GameHighLightAdapter(fragment : Fragment, val vm : GameHighLightViewModel) : BaseAdapter(fragment.context!!, fragment) {
    override fun createViewHolder(binding: ViewDataBinding): BaseViewHolder = GameHighLightViewHolder(binding as ItemHighlightBinding, vm)

    override fun getLayoutId(viewType: Int): Int = R.layout.item_highlight

    override fun getItemCount(): Int = itemList.size
}