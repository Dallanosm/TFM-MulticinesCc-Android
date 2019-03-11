package com.multicinescc.data

import com.multicinescc.data.network.NetworkRepository
import com.multicinescc.domain.models.Movie
import com.multicinescc.domain.repository.MoviesRepository
import io.reactivex.Single

class MoviesDataSource(private val network: NetworkRepository) : MoviesRepository {

    override fun getMovies(): Single<List<Movie>> = network.getMovies()
}