package com.avatar.inpsection.data.network

import com.sr.dummyapidemo.data.response.EmployeeData
import retrofit2.Response
import retrofit2.http.GET


/**
 * Created by ramesh on 16-10-2021
 */
interface RetrofitInterface {
    @GET("employees")
    suspend fun getEmployeeData(): Response<EmployeeData>?
}