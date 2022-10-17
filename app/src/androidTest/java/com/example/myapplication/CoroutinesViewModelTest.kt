package com.example.myapplication

import com.example.myapplication.usecase.GetListDataUseCase
import com.example.myapplication.usecase.StoryRepository
import com.example.myapplication.viewmodel.CoroutinesViewModel
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CoroutinesViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Mock
    lateinit var storyRepository: StoryRepository


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getListDataLiveData() = runTest {
        val getListDataUseCase = GetListDataUseCase(storyRepository)
        val testScheduler = TestCoroutineScheduler()
        val dispatcher = UnconfinedTestDispatcher(testScheduler)
        Mockito.`when`(getListDataUseCase.execute()).thenReturn(mutableListOf("a", "b"))
        advanceUntilIdle()
        val coroutinesViewModel = CoroutinesViewModel(getListDataUseCase, mainDispatcherRule.testDispatchers, dispatcher, dispatcher)

        Mockito.verify(storyRepository).getListData()

        val count = coroutinesViewModel.listDataLiveData.value?.size


        assertEquals(2, count)
    }
}