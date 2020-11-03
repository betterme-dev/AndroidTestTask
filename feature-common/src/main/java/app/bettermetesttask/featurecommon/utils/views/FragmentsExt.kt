package app.bettermetesttask.featurecommon.utils.views

import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

inline fun Fragment.handleBackPressed(autoDispose: Boolean = true, crossinline action: () -> Unit) {
    requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            action()
            if (autoDispose) {
                remove()
            }
        }
    })
}