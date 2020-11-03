package app.bettermetesttask.domaincore.utils.rx

import io.reactivex.Scheduler

object AppSchedulers {

    private lateinit var instance: SchedulerProvider

    fun setInstance(instance: SchedulerProvider) {
        AppSchedulers.instance = instance
    }

    fun io(): Scheduler = instance.io()

    fun mainThread(): Scheduler = instance.mainThread()

    fun computation(): Scheduler = instance.computation()

    fun newThread(): Scheduler = instance.newThread()

    fun trampoline(): Scheduler = instance.trampoline()

}