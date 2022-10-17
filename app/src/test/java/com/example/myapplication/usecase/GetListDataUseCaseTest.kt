package com.example.myapplication.usecase

import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetListDataUseCaseTest {

    @Mock
    lateinit var storyRepo: StoryRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown() {
    }


    @Test
    fun execute() = runTest {
        val useCase = GetListDataUseCase(storyRepo)
        Mockito.`when`(useCase.execute()).thenReturn(mutableListOf("Data1", "Data2"))

        val result = useCase.execute()

        assert(result.last() == "Data2")
    }
}