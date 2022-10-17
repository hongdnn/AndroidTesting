package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.DispatcherProvider
import com.example.myapplication.di.IoDispatcher
import com.example.myapplication.di.MainDispatcher
import com.example.myapplication.usecase.GetListDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CoroutinesViewModel @Inject constructor(
    private val getListDataUseCase: GetListDataUseCase,
    private val dispatcherProvider: DispatcherProvider,
    @MainDispatcher private val mainDispatcher: CoroutineDispatcher,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : ViewModel(){

    init {
        getListData()
    }


    val listDataLiveData by lazy {
        MutableLiveData<List<String>>() }

    fun getListData() {
        viewModelScope.launch(dispatcherProvider.io) {
            val list = getListDataUseCase.execute()
            withContext(dispatcherProvider.main) {
                listDataLiveData.value = list
            }
        }
    }
}