package com.nwar.umjunsik.ui.adapter

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.nwar.umjunsik.R
import com.nwar.umjunsik.databinding.ItemNewsfeedBinding
import com.nwar.umjunsik.ui.base.BaseAdapter
import com.nwar.umjunsik.ui.base.BaseViewHolder
import com.nwar.umjunsik.ui.viewholder.NewsFeedViewHolder
import com.nwar.umjunsik.viewModel.viewModel.NewsFeedViewModel

class NewsFeedAdapter(fragment : Fragment, val vm : NewsFeedViewModel) : BaseAdapter(fragment.context!!, fragment) {
    override fun createViewHolder(binding: ViewDataBinding): BaseViewHolder = NewsFeedViewHolder(binding as ItemNewsfeedBinding, vm)

    override fun getLayoutId(viewType: Int): Int = R.layout.item_newsfeed

    override fun getItemCount(): Int = itemList.size
}