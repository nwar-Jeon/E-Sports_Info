package com.nwar.umjunsik.extend.extendFunction

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<MutableList<T>>.postValueOneItem(position : Int, action : (item : T) -> T) {
    if(this.value==null) return
    if(position !in this.value!!.indices) return
    this.value!![position] = action(this.value!![position])
    this.postValue(this.value!!)
}

operator fun <T> MutableLiveData<MutableList<T>>.get(position : Int) = this.value!![position]

fun <T>ObservableField<T>.doActionAndNotifyChange(action: (T) -> Unit) {
    action(this.get()!!)
    this.notifyChange()
}

fun <T>ObservableField<T>.doAction(action: (T) -> Unit) : ObservableField<T> {
    action(this.get()!!)
    return this
}

fun <T>MutableLiveData<T>.isNotNull() : Boolean = this.value!=null

fun MutableLiveData<String>.isNotEmpty() : Boolean = if(this.isNotNull()) this.value!!.isNotEmpty() else false