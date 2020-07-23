package com.nwar.umjunsik.lifecycle

import androidx.lifecycle.Lifecycle

interface LifecycleListener {
    fun apply(event : Lifecycle.Event)
}