package com.avatar.inpsection.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.example.githubrepodetailsapp.data.network.NoInternetException
import com.sr.dummyapidemo.AppApplication
import com.sr.dummyapidemo.R
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Created by ramesh on 16-10-2021
 */
class NetworkInterceptor : Interceptor{

    var applicationContext: Context = AppApplication.instance

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isNetworkAvailable()) {
            throw NoInternetException(applicationContext.getString(R.string.no_internet_msg))
        }
        return chain.proceed(chain.request())
    }

    fun isNetworkAvailable(): Boolean {
        val connectivityManager = applicationContext.
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

}