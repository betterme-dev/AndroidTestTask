package app.bettermetesttask.featurecommon.utils.views

import android.view.View
import androidx.core.view.isVisible

/**
 * Sets visibility to [View.VISIBLE].
 */
fun View.visible() {
    if (isVisible) {
        return
    }
    visibility = View.VISIBLE
}

/**
 * Sets visibility to [View.GONE].
 */
fun View.gone() {
    if (!isVisible) {
        return
    }
    visibility = View.GONE
}