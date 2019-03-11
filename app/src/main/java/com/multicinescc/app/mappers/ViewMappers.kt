package com.multicinescc.app.mappers

import com.multicinescc.app.models.MovieView
import com.multicinescc.app.models.ScheduleView
import com.multicinescc.domain.models.Movie
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