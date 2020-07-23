package com.nwar.umjunsik.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(val root : View) : RecyclerView.ViewHolder(root) {
    val index : Int
    get() = adapterPosition

    abstract fun bind(list : List<Any>)
}