package com.multicinescc.app.view.activity

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.multicinescc.app.R
import com.multicinescc.app.extension.load
import com.multicinescc.app.models.MovieDetailView
import com.multicinescc.app.navigator.openVideo
import com.multicinescc.app.presenter.MovieDetailsPresenter
import com.multicinescc.app.view.adapter.NextPassAdapter
import com.multicinescc.app.view.dialog.CommentsDialog
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_movie_details.*


class MovieDetailsActivity : RootActivity<MovieDetailsPresenter.View>(), MovieDetailsPresenter.View {

    companion object {
        const val DIALOG_TAG = "DIALOG"
        const val MOVIE_ID_KEY = "MOVIE_ID_KEY"

        fun getCallingIntent(context: Context, id: Long): Intent {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(MOVIE_ID_KEY, id)
            return intent
        }
    }

    override val progress: View by lazy { progressView }

    override val presenter: MovieDetailsPresenter by instance()

    override val layoutResourceId: Int = R.layout.activity_movie_details

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<MovieDetailsPresenter>() with provider {
            MovieDetailsPresenter(
                    retrieveMovieDetailUseCase = instance(),
                    view = this@MovieDetailsActivity,
                    errorHandler = instance()
            )
        }
    }

    private val nextPassAdapter = NextPassAdapter()

    override fun initializeUI() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        nextPasses.adapter = nextPassAdapter
        nextPasses.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
    }

    override fun registerListeners() {
        seeTrailer.setOnClickListener { presenter.onSeeTrailerClicked() }
        seeComments.setOnClickListener { presenter.onSeeComments() }
    }

    override fun getMovieId(): Long {
        return intent?.extras?.getLong(MOVIE_ID_KEY) ?: throw Exception("Id must be not null")
        //return 4311
    }

    override fun showDetails(movieDetail: MovieDetailView) {
        movieTitle.text = movieDetail.title
        classification.text = movieDetail.classification
        movieImage.load(movieDetail.image)

        val options = RequestOptions()
        options.fitCenter()

        Glide.with(background).load(movieDetail.image)
                .apply(options)
                .apply(bitmapTransform(BlurTransformation(25, 3)))
                .into(background)

        sinopsis.text = movieDetail.sinopsis
        nextPassAdapter.replace(movieDetail.tickets.map { it.time }.toMutableList())
    }

    override fun showTrailer(movieUrl: String) {
        openVideo(this, videoURL = movieUrl)

        /*   lifecycle.addObserver(player)
           imageContent.hideMe()
           player.showMe()
           player.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
               override fun onReady(youTubePlayer: YouTubePlayer) {
                   youTubePlayer.loadVideo(id, 0f)
               }
           })*/
    }

    override fun navigateToCommentsScreen(id: Long) {
        val commentsDialog = CommentsDialog.newInstance(id)
        commentsDialog.show(supportFragmentManager, DIALOG_TAG)
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}