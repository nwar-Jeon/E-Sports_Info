package com.nwar.umjunsik.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import com.nwar.umjunsik.lifecycle.LifecycleListener
import com.nwar.umjunsik.lifecycle.LifecycleOwner
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import org.jetbrains.anko.toast
import javax.inject.Inject

abstract class BaseActivity<V : ViewDataBinding>() : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    abstract val layoutId : Int
    abstract val viewModel : BaseViewModel
    lateinit var binding : V
    val lifecycleOwner = LifecycleOwner()

    fun registerListener(listener: LifecycleListener) = lifecycleOwner.registerLifecycleListener(listener)

    fun removeListener() = lifecycleOwner.removeLifecycleListener()

    override fun onDestroy() {
        sendEvent(Lifecycle.Event.ON_DESTROY)
        removeListener()
        super.onDestroy()
    }

    override fun onStop() {
        sendEvent(Lifecycle.Event.ON_STOP)
        super.onStop()
    }

    override fun onResume() {
        sendEvent(Lifecycle.Event.ON_RESUME)
        super.onResume()
    }

    override fun onStart() {
        sendEvent(Lifecycle.Event.ON_START)
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        registerListener(viewModel)
        sendEvent(Lifecycle.Event.ON_CREATE)
        binding = DataBindingUtil.setContentView(this,layoutId)
        binding.lifecycleOwner = this
        viewModel.toast.observe(this, Observer { if(it!=null) toast(it) })
    }

    override fun onPause() {
        sendEvent(Lifecycle.Event.ON_PAUSE)
        super.onPause()
    }

    fun sendEvent(event : Lifecycle.Event) = lifecycleOwner.sendLifecycleEvent(event)
}