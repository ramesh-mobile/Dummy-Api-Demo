package com.sr.dummyapidemo.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sr.dummyapidemo.R
import com.sr.dummyapidemo.data.response.EmpData
import com.sr.dummyapidemo.databinding.ActivityMainBinding
import com.sr.dummyapidemo.utils.ViewUtil.hide
import com.sr.dummyapidemo.utils.ViewUtil.show
import com.sr.dummyapidemo.utils.ViewUtil.snack

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    private lateinit var recyclerView: RecyclerView

    private var empDataList : MutableList<EmpData> = mutableListOf()

    private lateinit var allDataAdapter : AllDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        recyclerView = binding.layout.recyclerView

        allDataAdapter = AllDataAdapter(empDataList)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = allDataAdapter

        viewModel.employeeDataLD.observe(this,Observer {
            try {
                binding.layout.progressBar.hide()
                empDataList.clear()
                empDataList.addAll(it)
                allDataAdapter.notifyDataSetChanged()
            }catch (npe:NullPointerException){
                recyclerView.snack(getString(R.string.error_to_fetch))
            }
        })
        fetchData()
    }

    fun fetchData(){
        viewModel.fetchEmployeeData()
        binding.layout.progressBar.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if(item.itemId == R.id.action_refresh){
            fetchData()
        }
        return true
    }
}