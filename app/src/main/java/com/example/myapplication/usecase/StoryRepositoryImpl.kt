package com.example.myapplication.usecase

import io.reactivex.rxjava3.core.Observable

class StoryRepositoryImpl : StoryRepository {
    override fun getStory(): Observable<String> {
        return Observable.just("story A")
    }

    override fun getX(): String {
        return "A"
    }

}