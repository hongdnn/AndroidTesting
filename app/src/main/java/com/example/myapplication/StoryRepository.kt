package com.example.myapplication

import io.reactivex.rxjava3.core.Observable

interface StoryRepository {
    fun getStory() : Observable<String>

    fun getX() : String
}