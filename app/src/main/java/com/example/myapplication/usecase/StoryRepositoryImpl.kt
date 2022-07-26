package com.example.myapplication.usecase

import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class StoryRepositoryImpl @Inject constructor() : StoryRepository {
    override fun getStory(): Observable<String> {
        return Observable.just("Story A")
    }

    override fun getX(): String {
        return "A"
    }

}