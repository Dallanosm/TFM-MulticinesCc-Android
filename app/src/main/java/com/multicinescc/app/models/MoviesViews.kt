package com.multicinescc.app.models


data class MovieView(
        val id: String,
        val title: String,
        val img: String,
        val classification: String,
        val schedule: List<ScheduleView>
)

data class MovieDetailView(
        val title: String,
        val image: String,
        val country: String,
        val year: String,
        val duration: String,
        val director: String,
        val releaseDate: String,
        val classification: String,
        val cast: List<ActorView>,
        val sinopsis: String,
        val trailer: String,
        val tickets: List<ScheduleView>
)

data class ActorView(
        val name: String,
        val image: String
)

data class ScheduleView(
        val time: String,
        val paymentUrl: String,
        val price: String
)

data class CommentView(
        val id: Long,
        val createdDate: String,
        val value: String
)