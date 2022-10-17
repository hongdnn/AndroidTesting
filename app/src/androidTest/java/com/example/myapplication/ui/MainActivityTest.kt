package com.example.myapplication.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.R
import com.example.myapplication.TestScheduleProvider
import com.example.myapplication.usecase.GetListDataUseCase
import com.example.myapplication.usecase.GetStoryUseCase
import com.example.myapplication.usecase.StoryRepository
import com.example.myapplication.viewmodel.MainViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.TestScheduler
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var storyRepository: StoryRepository


    @Before
    fun setUp() {
        appLaunchesSuccessfully()
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(allOf(withId(R.id.tvTest), withText("Test")))
            .check(matches(isDisplayed()))
        onView(withId(R.id.btnTest))
            .check(matches(isDisplayed()))
    }


    @Test
    fun loadDataTest() {

        val scheduler = TestScheduler()
        val schedulerProvider = TestScheduleProvider(scheduler)
        val getStoryUseCase = GetStoryUseCase(storyRepository)
        val mainViewModel = MainViewModel(getStoryUseCase, schedulerProvider)

        Mockito.`when`(getStoryUseCase.execute()).thenReturn(Observable.just("Story 1"))

        mainViewModel.loadData()
        scheduler.triggerActions()

        Mockito.verify(storyRepository).getStory()
        getStoryUseCase.execute().test()
            .assertNoErrors()
            .assertComplete()
        assert(mainViewModel.storyLiveData.value == "Story 1")


//        onView(withId(R.id.tvTest))
//            .check(matches(withText("Test")))
//        onView(withId(R.id.btnTest))
//            .perform(click())
//        onView(withId(R.id.tvTest))
//            .check(matches(withText("Story A")))
    }
}