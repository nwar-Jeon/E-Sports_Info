package com.nwar.umjunsik.ui.base

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.nwar.domain.entity.HighLight

abstract class BaseAdapter(val context : Context, private val lifeCycleOwner : LifecycleOwner? = null) : RecyclerView.Adapter<BaseViewHolder>() {

    var itemList : List<Any> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(context),getLayoutId(viewType),parent,false)
        return createViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(itemList)
    }

    abstract fun getLayoutId(viewType: Int) : Int

    abstract fun createViewHolder(binding : ViewDataBinding) : BaseViewHolder

    fun changeItemList(list : List<Any>) {
        itemList.indices.forEach {
            if(itemList[it]!=list[it]) { notifyItemChanged(it) }
        }
        (itemList.size until list.size).forEach {
            notifyItemInserted(it)
        }
        itemList = list.toList()
    }
}