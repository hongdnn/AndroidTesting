package com.example.myapplication.usecase

import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetStoryUseCase @Inject constructor(private val storyRepository: StoryRepository){
    fun execute() : Observable<String> {
        return storyRepository.getStory()
    }
}