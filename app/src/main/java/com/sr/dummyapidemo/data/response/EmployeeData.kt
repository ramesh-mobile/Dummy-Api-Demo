package com.sr.dummyapidemo.data.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ramesh on 16-10-2021
 */
data class EmployeeData(
    @SerializedName("status")
    @Expose
    var status: String,

    @SerializedName("data")
    @Expose
    var empData : List<EmpData>

)


data class EmpData(
    @SerializedName("id")
    @Expose var eId : Int,

    @SerializedName("employee_name")
    @Expose var eName : String,

    @SerializedName("employee_salary")
    @Expose var eSalary : Int,
)
