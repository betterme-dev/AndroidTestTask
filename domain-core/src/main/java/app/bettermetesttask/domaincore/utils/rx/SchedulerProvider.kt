package app.bettermetesttask.domaincore.utils.rx

import io.reactivex.Scheduler

interface SchedulerProvider {

    fun io(): Scheduler

    fun mainThread(): Scheduler

    fun computation(): Scheduler

    fun newThread(): Scheduler

    fun trampoline(): Scheduler
}