package app.bettermetesttask.featurecommon.utils.context

import android.content.Context

/**
 * Converts dps to pixel value.
 */
fun Context.dipToPx(dip: Float): Int {
    val density = this.resources.displayMetrics.density
    return (dip * density + 0.5f * if (dip >= 0) 1 else -1).toInt()
}