package com.example.mvvmwithhilt.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmwithhilt.R
import com.example.mvvmwithhilt.models.BaseResponse
import com.example.mvvmwithhilt.models.User
import com.example.mvvmwithhilt.ui.adapters.UserAdapter
import com.example.mvvmwithhilt.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel by viewModels<MainViewModel>()
    lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
        getUserData()
    }

    private fun getUserData() {
        viewModel.getUserList().observe(this, Observer { response ->
            when (response) {
                is BaseResponse.Loading -> {
                    progressbar.visibility = View.VISIBLE
                }
                is BaseResponse.Failed -> {
                    progressbar.visibility = View.GONE
                }
                is BaseResponse.Success -> {
                    response.data?.data?.let { adapter.setData(it) }
                    progressbar.visibility = View.GONE
                }
            }
        })
    }

    private fun setAdapter() {
        adapter = UserAdapter { pos, data ->
            Toast.makeText(this, data.first_name + "Clicked", Toast.LENGTH_LONG).show()
        }
        rv_users.adapter=adapter
        rv_users.layoutManager = LinearLayoutManager(this)
    }
}