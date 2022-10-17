package com.example.myapplication.usecase

import javax.inject.Inject

class GetListDataUseCase @Inject constructor(private val storyRepository: StoryRepository) {
    suspend fun execute() : List<String> {
        return storyRepository.getListData()
    }
}