package com.example.myapplication

import com.example.myapplication.usecase.GetStoryUseCase
import com.example.myapplication.usecase.StoryRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import java.util.*


class GetStoryUseCaseTest {

    @Mock
    lateinit var storyRepo: StoryRepository

    @Mock
    lateinit var list: Vector<String>

    @Spy
    lateinit var spyList: Vector<String>


    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun getStoryTest() {

        Mockito.`when`(storyRepo.getStory()).thenReturn(Observable.just("story B"))

        val scheduler = TestScheduler()
        val getStory = GetStoryUseCase(storyRepository = storyRepo)

        val storyTest = getStory.execute().test()

//        Mockito.`when`(list[0]).thenReturn("C")
//        spyList.add("C")
//
//        assert(spyList[0] == "C")
//        assertEquals(list[0], "C")


       // scheduler.triggerActions()
        storyTest.assertComplete()
        storyTest.assertNoErrors()
        assert(storyTest.values()[0] == "story B")

    }
}