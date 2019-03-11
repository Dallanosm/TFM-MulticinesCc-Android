package com.multicinescc.app.view.activity

import android.graphics.Typeface
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.eftimoff.viewpagertransformers.BackgroundToForegroundTransformer
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.multicinescc.app.R
import com.multicinescc.app.models.MovieView
import com.multicinescc.app.presenter.MoviesPresenter
import com.multicinescc.app.view.adapter.MoviesAdapter
import com.multicinescc.app.view.adapter.NextPassAdapter
import com.multicinescc.domain.constants.Constants.Companion.EMPTY_STRING
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

    private val nextPassAdapter = NextPassAdapter()

    lateinit var movies: List<MovieView>

    override fun initializeUI() {
        movieTitle.typeface = Typeface.createFromAsset(assets, "open-sans-extrabold.ttf")
        nextPasses.adapter = nextPassAdapter
        nextPasses.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
    }

    override fun registerListeners() {
        moviesImages.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                showMovieInfo(position)
            }

        })
    }

    override fun showMovies(movies: List<MovieView>) {
        this.movies = movies
        moviesImages.adapter = MoviesAdapter(this, movies)
        moviesImages.setPageTransformer(true, BackgroundToForegroundTransformer())
        showMovieInfo(0)
    }

    private fun showMovieInfo(index: Int) {
        val movie = movies[index]
        movieTitle.text = movie.title
        classification.text = movie.classification.split(",")[0]
        nextPassAdapter.replace(movie.schedule.map { it.time }.toMutableList())
        val p = movie.schedule.firstOrNull { it.price != EMPTY_STRING }?.price?.split("€")?.let { it[1] }
        price.text = "$p€"
    }

}