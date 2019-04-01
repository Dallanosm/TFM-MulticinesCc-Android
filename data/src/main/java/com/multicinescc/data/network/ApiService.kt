package com.multicinescc.data.network

import com.multicinescc.data.models.MovieDetailDto
import com.multicinescc.data.models.MoviesCommentDto
import com.multicinescc.data.models.MoviesResponseDto
import com.multicinescc.data.models.NewCommentDto
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    companion object {
        const val END_POINT = "http://llanosmunoz.com:8084/"
    }

    @GET("movies")
    fun getMovies(): Single<List<MoviesResponseDto>>

    @GET("movies/{id}")
    fun getMovie(@Path("id") id: Long): Single<MovieDetailDto>

    @GET("movies/{movieId}/comments")
    fun getComments(@Path("movieId") movieId: Long): Single<List<MoviesCommentDto>>

    @POST("movies/{movieId}/comments")
    fun addNewComment(@Path("movieId") movieId: Long,
                      @Body newComment: NewCommentDto): Single<List<MoviesCommentDto>>

}