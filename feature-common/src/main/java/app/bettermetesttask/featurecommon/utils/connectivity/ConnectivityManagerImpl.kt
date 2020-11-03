package app.bettermetesttask.featurecommon.utils.connectivity

import android.annotation.SuppressLint
import android.content.Context
import android.net.NetworkInfo
import androidx.core.content.getSystemService
import app.bettermetesttask.domaincore.utils.connectivity.ConnectivityManager
import javax.inject.Inject

class ConnectivityManagerImpl @Inject constructor(private val context: Context) : ConnectivityManager {

    @Suppress("DEPRECATION")
    @SuppressLint("MissingPermission")
    override fun isNetworkAvailable(): Boolean {
        val cm = context.getSystemService<android.net.ConnectivityManager>()
        val activeNetwork: NetworkInfo? = cm?.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

}