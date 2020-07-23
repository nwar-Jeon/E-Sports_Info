package com.nwar.umjunsik.extend.extendFunction

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nwar.umjunsik.ui.base.BaseAdapter

fun RecyclerView.initAdapter(adapter : BaseAdapter) {
    this.adapter = adapter
    this.layoutManager = LinearLayoutManager(adapter.context)
}
