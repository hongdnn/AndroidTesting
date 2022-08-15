package com.example.myapplication.di

import com.example.myapplication.SchedulerProvider
import com.example.myapplication.SchedulerProviderImpl
import com.example.myapplication.usecase.GetStoryUseCase
import com.example.myapplication.usecase.GetStoryUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class MainModule {

    @Binds
    abstract fun bindGetStoryUseCase(
        getStoryUseCaseImpl: GetStoryUseCaseImpl
    ): GetStoryUseCase

    @Binds
    abstract fun bindSchedulerProvider(
        schedulerProviderImpl: SchedulerProviderImpl
    ): SchedulerProvider
}