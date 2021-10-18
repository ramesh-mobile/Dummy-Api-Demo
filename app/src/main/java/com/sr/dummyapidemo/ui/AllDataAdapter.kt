package com.sr.dummyapidemo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sr.dummyapidemo.data.response.EmpData
import com.sr.dummyapidemo.databinding.EmployeeRowBinding

/**
 * Created by ramesh on 16-10-2021
 */
class AllDataAdapter(var empDataList:List<EmpData>) : RecyclerView.Adapter<AllDataAdapter.MyViewHolder>(){

    class MyViewHolder(val itemBinding:EmployeeRowBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(empData:EmpData){
            itemBinding.lblId.text =  empData.eId.toString()
            itemBinding.lblName.text =  empData.eName
            itemBinding.lblSalary.text =  empData.eSalary.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(EmployeeRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(empDataList[position])
    }

    override fun getItemCount()= empDataList.size
}