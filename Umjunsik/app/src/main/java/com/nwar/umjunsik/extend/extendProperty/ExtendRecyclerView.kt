package com.nwar.umjunsik.extend.extendProperty

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nwar.umjunsik.ui.base.BaseAdapter

var RecyclerView.baseAdapter
    get() = this.adapter
    set(value) {
        if (value is BaseAdapter) {
            this.adapter = value
            this.layoutManager = LinearLayoutManager(value.context)
        }
    }