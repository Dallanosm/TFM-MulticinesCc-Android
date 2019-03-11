package com.multicinescc.app.models


data class Movie(
        val id: String,
        val title: String,
        val img: String,
        val classification: String,
        val schedule: List<Schedule>
)

data class MovieDetail(
        val title: String,
        val image: String,
        val country: String,
        val year: String,
        val duration: String,
        val director: String,
        val releaseDate: String,
        val classification: String,
        val cast: List<Actor>,
        val sinopsis: String,
        val trailer: String,
        val tickets: List<Schedule>
)

data class Actor(
        val name: String,
        val image: String
)

data class Schedule(
        val time: String,
        val paymentUrl: String,
        val price: String
)