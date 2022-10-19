package com.example.myapplication.di

import com.example.myapplication.DispatcherProvider
import com.example.myapplication.DispatcherProviderImpl
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
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Module
@InstallIn(ViewModelComponent::class)
abstract class MainModule {

    @Binds
    abstract fun bindSchedulerProvider(
        schedulerProviderImpl: SchedulerProviderImpl
    ): SchedulerProvider

    @Binds
    abstract fun bindDispatcherProvider(
        dispatcherProviderImpl: DispatcherProviderImpl
    ): DispatcherProvider

    @Binds
    abstract fun bindStoryRepository(
        storyRepositoryImpl: StoryRepositoryImpl
    ): StoryRepository


}
