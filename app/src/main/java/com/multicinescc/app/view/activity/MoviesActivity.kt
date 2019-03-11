package com.multicinescc.app.view.activity

import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.multicinescc.app.R
import com.multicinescc.app.models.Movie
import com.multicinescc.app.presenter.MoviesPresenter
import kotlinx.android.synthetic.main.activity_movies.*

class MoviesActivity : RootActivity<MoviesPresenter.View>(), MoviesPresenter.View {

    override val progress: View  by lazy { progressView }

    override val presenter: MoviesPresenter by instance()

    override val layoutResourceId: Int = R.layout.activity_movies

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<MoviesPresenter>() with provider {
            MoviesPresenter(
                    retrieveMoviesUseCase = instance(),
                    view = this@MoviesActivity,
                    errorHandler = instance())
        }
    }

    override fun initializeUI() {
        // Nothing to do yet
    }

    override fun registerListeners() {
        // Nothing to do yet
    }

    override fun showMovies(movies: List<Movie>) {
        // Nothing to do yet
    }


}