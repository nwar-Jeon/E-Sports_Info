package com.nwar.umjunsik.lifecycle

import androidx.lifecycle.Lifecycle

class LifecycleOwner() {
    val lifecycleListenerList: ArrayList<LifecycleListener> = arrayListOf()

    fun registerLifecycleListener(listener: LifecycleListener) = lifecycleListenerList.add(listener)

    fun removeLifecycleListener() = lifecycleListenerList.clear()

    fun sendLifecycleEvent(event : Lifecycle.Event) {
        for (listener: LifecycleListener in lifecycleListenerList) {
            listener.apply(event)
        }
    }
}