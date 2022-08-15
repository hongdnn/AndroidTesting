package com.example.myapplication.usecase

import io.reactivex.rxjava3.core.Observable

interface GetStoryUseCase {
    fun getStory() : Observable<String>
}