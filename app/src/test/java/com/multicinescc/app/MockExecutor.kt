package com.multicinescc.app

import com.multicinescc.domain.executor.Executor
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * MockExecutor.
 */
class MockExecutor : Executor {
    override fun new(): Scheduler = Schedulers.trampoline()

    override fun main(): Scheduler = Schedulers.trampoline()
}
