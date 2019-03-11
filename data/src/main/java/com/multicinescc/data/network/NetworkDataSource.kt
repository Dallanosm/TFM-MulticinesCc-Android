package com.multicinescc.data.network

import com.multicinescc.data.mappers.toDomain
import com.multicinescc.domain.models.Movie
import com.multicinescc.domain.models.MovieDetail
import io.reactivex.Single

class NetworkDataSource(private val service: ApiService) : NetworkRepository {

    override fun getMovies(): Single<List<Movie>> =
            service.getMovies()
                    .map { movies ->
                        movies.map { movie ->
                            movie.toDomain()
                        }
                    }

    override fun getMovie(id: Long): Single<MovieDetail>  =
            service.getMovie( id = id)
                    .map { it.toDomain() }
}
