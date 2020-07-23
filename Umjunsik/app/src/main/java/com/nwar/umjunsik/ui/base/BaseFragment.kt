package com.nwar.umjunsik.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.nwar.umjunsik.lifecycle.LifecycleListener
import com.nwar.umjunsik.lifecycle.LifecycleOwner
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

abstract class BaseFragment<V : ViewDataBinding>() : Fragment(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>
    abstract val layoutId : Int
    abstract val viewModel : BaseViewModel
    lateinit var binding : V
    val lifecycleOwner = LifecycleOwner()
    val navController by lazy { NavHostFragment.findNavController(this) }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    fun navigate(action : Int) = navController.navigate(action)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AndroidSupportInjection.inject(this)
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        setViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerListener(viewModel)
        sendEvent(Lifecycle.Event.ON_CREATE)
        viewModel.toast.observe(this, Observer { if(it!=null) toast(it) })
    }

    override fun onResume() {
        sendEvent(Lifecycle.Event.ON_RESUME)
        super.onResume()
    }

    override fun onDestroy() {
        sendEvent(Lifecycle.Event.ON_DESTROY)
        removeListener()
        super.onDestroy()
    }

    override fun onPause() {
        sendEvent(Lifecycle.Event.ON_PAUSE)
        super.onPause()
    }

    override fun onStart() {
        sendEvent(Lifecycle.Event.ON_START)
        super.onStart()
    }

    override fun onStop() {
        sendEvent(Lifecycle.Event.ON_STOP)
        super.onStop()
    }

    fun registerListener(listener: LifecycleListener) = lifecycleOwner.registerLifecycleListener(listener)

    fun removeListener() = lifecycleOwner.removeLifecycleListener()

    fun sendEvent(event : Lifecycle.Event) = lifecycleOwner.sendLifecycleEvent(event)

    abstract fun setViewModel()
}