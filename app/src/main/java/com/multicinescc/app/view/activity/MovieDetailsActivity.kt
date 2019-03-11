package com.multicinescc.app.view.activity

import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.multicinescc.app.R
import com.multicinescc.app.models.MovieDetailView
import com.multicinescc.app.presenter.MovieDetailsPresenter
import com.multicinescc.app.presenter.Presenter

class MovieDetailsActivity : RootActivity<MovieDetailsPresenter.View>(), MovieDetailsPresenter.View {

    override val progress: View
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val presenter: Presenter<MovieDetailsPresenter.View>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val layoutResourceId: Int = R.layout.activity_movie_details

    override val activityModule: Kodein.Module
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun initializeUI() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerListeners() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDetails(movieDetail: MovieDetailView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}