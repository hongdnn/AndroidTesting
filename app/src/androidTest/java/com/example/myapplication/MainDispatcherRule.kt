package com.example.myapplication

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class MainDispatcherRule(
    val testDispatchers: TestDispatcherProvider = TestDispatcherProvider()
) : TestWatcher() {
    override fun starting(description: Description) {
        Dispatchers.setMain(testDispatchers.testDispatcher)
    }

    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }

}