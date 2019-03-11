package com.multicinescc.app.di

import android.content.Context
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.singleton
import com.multicinescc.domain.executor.Executor
import com.multicinescc.app.error.ErrorHandler
import com.multicinescc.app.error.AndroidErrorHandler
import com.multicinescc.app.executor.RxExecutor

/**
 * Modules
 */
fun appModule(context: Context) = Kodein.Module {
    bind<Context>() with singleton { context }
    bind<Executor>() with singleton { RxExecutor() }
    bind<ErrorHandler>() with singleton { AndroidErrorHandler(context = context) }
}

val domainModule = Kodein.Module {
    // Add here data dependencies
}

val dataModule = Kodein.Module {
    // Add here data dependencies
}
