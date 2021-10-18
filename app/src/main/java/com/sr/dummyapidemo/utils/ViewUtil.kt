package com.sr.dummyapidemo.utils

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar

/**
 * Created by ramesh on 16-10-2021
 */
object ViewUtil {

    fun ViewModel.print(TAG : String, msg: String){
        Log.d(TAG, "$msg")
    }

    fun View.snack(msg:String){
        Snackbar.make(this,"$msg", Snackbar.LENGTH_LONG).show()
    }

    fun View.hide(){
        this.visibility = View.GONE
    }

    fun View.show(){
        this.visibility = View.VISIBLE
    }
}