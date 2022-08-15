package com.example.myapplication.usecase

import io.reactivex.rxjava3.core.Observable

interface StoryRepository {
    fun getStory() : Observable<String>

    fun getX() : String
}