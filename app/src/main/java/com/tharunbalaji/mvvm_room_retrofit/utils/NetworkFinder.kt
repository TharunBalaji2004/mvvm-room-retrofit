package com.tharunbalaji.mvvm_room_retrofit.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class NetworkFinder {
    companion object {
        fun isInternetAvailable(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            // Check for network connection
            connectivityManager.activeNetwork?.let { network ->
                val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
                return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    ?: false
            }
            return false
        }
    }
}