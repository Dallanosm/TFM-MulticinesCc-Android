package com.multicinescc.data.models

import com.google.gson.annotations.SerializedName


data class MoviesResponseDto(
        @SerializedName("classification") val classification: String,
        @SerializedName("id") val id: String,
        @SerializedName("img") val img: String,
        @SerializedName("schedule") val schedule: List<ScheduleDto>,
        @SerializedName("title") val title: String
)

data class ScheduleDto(
        @SerializedName("paymentUrl") val paymentUrl: String,
        @SerializedName("price") val price: String,
        @SerializedName("time") val time: String
)

data class MovieDetailDto(
        @SerializedName("cast") val cast: List<CastDto>,
        @SerializedName("classification") val classification: String,
        @SerializedName("country") val country: String,
        @SerializedName("director") val director: String,
        @SerializedName("duration") val duration: String,
        @SerializedName("image") val image: String,
        @SerializedName("releaseDate") val releaseDate: String,
        @SerializedName("sinopsis") val sinopsis: String,
        @SerializedName("tickets") val tickets: List<ScheduleDto>,
        @SerializedName("title") val title: String,
        @SerializedName("trailer") val trailer: String,
        @SerializedName("year") val year: String
)

data class CastDto(
        @SerializedName("image") val image: String,
        @SerializedName("name") val name: String
)

data class MoviesCommentDto(
        @SerializedName("id") val id: Long,
        @SerializedName("createdDate") val createdDate: Long,
        @SerializedName("value") val value: String
)