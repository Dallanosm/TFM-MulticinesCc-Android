package com.multicinescc.data.network

import com.multicinescc.domain.models.Movie
import io.reactivex.Single

interface NetworkRepository {
    fun getMovies(): Single<List<Movie>>
}