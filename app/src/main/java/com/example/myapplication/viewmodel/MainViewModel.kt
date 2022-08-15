package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.SchedulerProvider
import com.example.myapplication.usecase.GetStoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

@HiltViewModel
class MainViewModel : ViewModel() {
    @Inject private lateinit var getStoryUseCase: GetStoryUseCase
    @Inject private lateinit var schedulerProvider: SchedulerProvider

    val storyLiveData by lazy { MutableLiveData<String>() }

    fun loadData() {
        getStoryUseCase.getStory()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribeBy {
                it?.let { storyLiveData.value = it }
            }
    }
}