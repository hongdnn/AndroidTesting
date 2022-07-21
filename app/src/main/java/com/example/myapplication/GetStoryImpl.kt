package com.example.myapplication

import io.reactivex.rxjava3.core.Observable

class GetStoryImpl(private val storyRepository: StoryRepository, private val schedulerProvider: SchedulerProvider) : GetStory {
    override fun getStory(): Observable<String> {
        return storyRepository.getStory().subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
    }
}