package com.nwar.umjunsik

import android.os.Bundle
import androidx.databinding.ObservableInt
import com.nwar.umjunsik.databinding.ActivityMainBinding
import com.nwar.umjunsik.ui.base.BaseActivity
import com.nwar.umjunsik.viewModel.viewModel.MainActivityViewModel

class MainActivity() : BaseActivity<ActivityMainBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_main

    override val viewModel by lazy { MainActivityViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
