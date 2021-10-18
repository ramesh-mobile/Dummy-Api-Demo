package com.sr.dummyapidemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avatar.inpsection.data.network.RetrofitInterface
import com.example.githubrepodetailsapp.data.network.NoInternetException
import com.sr.dummyapidemo.data.di.component.DaggerRetroComponent
import com.sr.dummyapidemo.data.response.EmpData
import com.sr.dummyapidemo.utils.CorountinesUtils
import com.sr.dummyapidemo.utils.ViewUtil.print
import javax.inject.Inject

/**
 * Created by ramesh on 16-10-2021
 */
class MainActivityViewModel : ViewModel() {

    private val TAG = "MainActivityViewModel"

    private var employeeDataMLD = MutableLiveData<List<EmpData>>()
    val employeeDataLD get() = employeeDataMLD as LiveData<List<EmpData>>

    @Inject
    lateinit var retrofitInterface : RetrofitInterface

    init {
        DaggerRetroComponent.create().injectRetro(this)
    }

    fun fetchEmployeeData() {
        CorountinesUtils.io {
            try {
                var response = retrofitInterface.getEmployeeData()
                if(response?.isSuccessful==true){
                    var employeeData = response.body()
                    if(employeeData?.status.equals("success")){
                        print(TAG, "fetchEmployeeData: ${employeeData}")
                        employeeDataMLD.postValue(employeeData?.empData)
                    }
                }
                else
                    employeeDataMLD.postValue(null)
            }catch (nie : NoInternetException){
                employeeDataMLD.postValue(null)
                nie.printStackTrace()
            }
            catch (e: Exception){
                employeeDataMLD.postValue(null)
                e.printStackTrace()
            }
        }
    }


}