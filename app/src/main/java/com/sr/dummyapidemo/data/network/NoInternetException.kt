package com.example.githubrepodetailsapp.data.network

import java.io.IOException

/**
 * Created by ramesh on 16-10-2021
 */
class NoInternetException(var errorMessage: String) : IOException(
    errorMessage
) {
    override val message: String
        get() = errorMessage//"No network available, please check your WiFi or Data connection!"
}