package com.multicinescc.domain.repository

import com.multicinescc.domain.models.Movie
import com.multicinescc.domain.models.MovieDetail
import io.reactivex.Single

/**
 * Repository.
 */

interface MoviesRepository {
    fun getMovies(): Single<List<Movie>>
    fun getMovie(id: Long): Single<MovieDetail>
}