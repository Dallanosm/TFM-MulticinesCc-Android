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
