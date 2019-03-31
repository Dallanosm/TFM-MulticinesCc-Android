package com.multicinescc.app.di

import android.content.Context
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.multicinescc.app.error.AndroidErrorHandler
import com.multicinescc.app.error.ErrorHandler
import com.multicinescc.app.executor.RxExecutor
import com.multicinescc.data.MoviesDataSource
import com.multicinescc.data.network.ApiService
import com.multicinescc.data.network.NetworkDataSource
import com.multicinescc.data.network.NetworkRepository
import com.multicinescc.data.network.createService
import com.multicinescc.domain.executor.Executor
import com.multicinescc.domain.interactor.usecase.RetrieveCommentsByMovieUseCase
import com.multicinescc.domain.interactor.usecase.RetrieveMovieDetailUseCase
import com.multicinescc.domain.interactor.usecase.RetrieveMoviesUseCase
import com.multicinescc.domain.repository.MoviesRepository

/**
 * Modules
 */
fun appModule(context: Context) = Kodein.Module {
    bind<Context>() with singleton { context }
    bind<Executor>() with singleton { RxExecutor() }
    bind<ErrorHandler>() with singleton { AndroidErrorHandler(context = context) }
}

val domainModule = Kodein.Module {
    bind<RetrieveMoviesUseCase>() with singleton { RetrieveMoviesUseCase(repository = instance(), executor = instance()) }
    bind<RetrieveMovieDetailUseCase>() with singleton { RetrieveMovieDetailUseCase(repository = instance(), executor = instance()) }
    bind<RetrieveCommentsByMovieUseCase>() with singleton { RetrieveCommentsByMovieUseCase(repository = instance(), executor = instance()) }
}

val dataModule = Kodein.Module {
    /* Repositories */
    bind<MoviesRepository>() with singleton { MoviesDataSource(network = instance()) }

    /* DataSources */
    bind<NetworkRepository>() with singleton { NetworkDataSource(service = instance()) }

    /* API Service */
    bind<ApiService>() with singleton { createService<ApiService>(endPoint = ApiService.END_POINT) }

}
