package com.multicinescc.app.mappers

import com.multicinescc.app.models.ActorView
import com.multicinescc.app.models.MovieDetailView
import com.multicinescc.app.models.MovieView
import com.multicinescc.app.models.ScheduleView
import com.multicinescc.domain.models.Actor
import com.multicinescc.domain.models.Movie
import com.multicinescc.domain.models.MovieDetail
import com.multicinescc.domain.models.Schedule

fun Movie.toView() = MovieView(
        id = id,
        title = title,
        img = img,
        classification = classification,
        schedule = schedule.map { it.toView() }
)

fun Schedule.toView() = ScheduleView(
        time = time,
        paymentUrl = paymentUrl,
        price = price
)

fun MovieDetail.toView() = MovieDetailView(
        title = title,
        image = image,
        country = country,
        year = year,
        duration = duration,
        director = director,
        releaseDate = releaseDate,
        classification = classification,
        cast = cast.map { it.toView() },
        sinopsis = sinopsis,
        trailer = trailer,
        tickets = tickets.map { it.toView() }
)

fun Actor.toView() = ActorView(
        name = name,
        image = image
)