package com.multicinescc.domain.repository

import com.multicinescc.domain.models.Movie
import io.reactivex.Single

/**
 * Repository.
 */

interface MoviesRepository {
    fun getMovies(): Single<List<Movie>>
}