package com.example.myapplication

import io.reactivex.rxjava3.core.Observable

interface GetStory {
    fun getStory() : Observable<String>
}