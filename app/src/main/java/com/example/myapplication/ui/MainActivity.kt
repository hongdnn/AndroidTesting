package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewmodel.CoroutinesViewModel
import com.example.myapplication.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val mainViewModel by viewModels<MainViewModel>()
    private val coroutinesViewModel by viewModels<CoroutinesViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnTest.setOnClickListener(this)

        mainViewModel.storyLiveData.observe(this) { data ->
            binding.tvTest.text = data
        }

        coroutinesViewModel.listDataLiveData.observe(this) { data ->
            binding.tvTest.text = data[data.size - 1]
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnTest -> loadData()
        }
    }

    private fun loadData() {
        mainViewModel.loadData()
    }
}