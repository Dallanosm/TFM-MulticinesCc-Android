package com.multicinescc.data

import com.multicinescc.data.network.NetworkRepository
import com.multicinescc.domain.models.Comment
import com.multicinescc.domain.models.Movie
import com.multicinescc.domain.models.MovieDetail
import com.multicinescc.domain.repository.MoviesRepository
import io.reactivex.Single

class MoviesDataSource(private val network: NetworkRepository) : MoviesRepository {

    override fun getMovies(): Single<List<Movie>> = network.getMovies()

    override fun getMovie(id: Long): Single<MovieDetail> = network.getMovie(id = id)

    override fun getComments(movieId: Long): Single<List<Comment>> = network.getComments(movieId)
}