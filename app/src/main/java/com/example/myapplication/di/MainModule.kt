package com.example.myapplication.di

import com.example.myapplication.SchedulerProvider
import com.example.myapplication.SchedulerProviderImpl
import com.example.myapplication.usecase.GetStoryUseCase
import com.example.myapplication.usecase.StoryRepository
import com.example.myapplication.usecase.StoryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MainModule {

//    @Binds
//    abstract fun bindGetStoryUseCase(
//        getStoryUseCaseImpl: GetStoryUseCaseImpl
//    ): GetStoryUseCase

    @Binds
    abstract fun bindSchedulerProvider(
        schedulerProviderImpl: SchedulerProviderImpl
    ): SchedulerProvider

    @Binds
    abstract fun bindStoryRepository(
        storyRepositoryImpl: StoryRepositoryImpl
    ): StoryRepository
}