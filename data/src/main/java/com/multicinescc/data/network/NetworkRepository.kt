package com.multicinescc.data.network

import com.multicinescc.domain.models.Comment
import com.multicinescc.domain.models.Movie
import com.multicinescc.domain.models.MovieDetail
import io.reactivex.Single

interface NetworkRepository {
    fun getMovies(): Single<List<Movie>>
    fun getMovie(id: Long): Single<MovieDetail>
    fun getComments(movieId: Long): Single<List<Comment>>
    fun addNewComment(newComment: String, movieId: Long): Single<List<Comment>>
}