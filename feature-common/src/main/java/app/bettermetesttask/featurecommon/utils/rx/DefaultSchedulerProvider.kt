package app.bettermetesttask.featurecommon.utils.rx

import app.bettermetesttask.domaincore.utils.rx.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DefaultSchedulerProvider : SchedulerProvider {

    override fun io(): Scheduler = Schedulers.io()

    override fun mainThread(): Scheduler = AndroidSchedulers.mainThread()

    override fun computation(): Scheduler = Schedulers.computation()

    override fun newThread(): Scheduler = Schedulers.newThread()

    override fun trampoline(): Scheduler = Schedulers.trampoline()

}