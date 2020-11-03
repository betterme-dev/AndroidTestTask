package app.bettermetesttask.featurecommon.injection.viewmodel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> Fragment.viewModel(factory: ViewModelProvider.Factory)
        = ViewModelProvider(this, factory)[T::class.java]

inline fun <reified T : ViewModel> FragmentActivity.viewModel(factory: ViewModelProvider.Factory)
    = ViewModelProvider(this, factory)[T::class.java]
