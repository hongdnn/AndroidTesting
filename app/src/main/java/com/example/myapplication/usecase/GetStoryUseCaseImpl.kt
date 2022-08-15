package com.example.myapplication.usecase

import com.example.myapplication.SchedulerProvider
import io.reactivex.rxjava3.core.Observable

class GetStoryUseCaseImpl(private val storyRepository: StoryRepository,) :
    GetStoryUseCase {
    override fun getStory(): Observable<String> {
        return storyRepository.getStory()
    }
}