package com.multicinescc.app.mappers

import com.multicinescc.app.models.*
import com.multicinescc.data.toFormattedString
import com.multicinescc.domain.constants.Constants.Companion.DATE_FORMAT
import com.multicinescc.domain.models.*

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

fun Comment.toView() = CommentView(
        id = id,
        createdDate = createdDate.toFormattedString(DATE_FORMAT),
        value = value
)