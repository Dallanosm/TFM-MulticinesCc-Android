package com.multicinescc.data.network

import com.multicinescc.data.models.MoviesResponseDto
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val END_POINT = "http://llanosmunoz.com:8084/"
    }

    @GET("movies")
    fun getMovies(): Single<List<MoviesResponseDto>>

}