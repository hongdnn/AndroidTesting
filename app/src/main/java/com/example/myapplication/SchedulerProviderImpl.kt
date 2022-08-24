package com.example.myapplication

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class SchedulerProviderImpl @Inject constructor() : SchedulerProvider {
    override fun io(): Scheduler {
        return Schedulers.io()
    }


    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }


    override fun computation(): Scheduler {
        return Schedulers.computation()
    }
}