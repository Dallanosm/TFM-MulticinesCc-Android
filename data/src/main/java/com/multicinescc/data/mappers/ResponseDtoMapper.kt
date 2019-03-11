package com.multicinescc.data.mappers

import com.multicinescc.data.models.MoviesResponseDto
import com.multicinescc.data.models.ScheduleDto
import com.multicinescc.domain.models.Movie
import com.multicinescc.domain.models.Schedule

fun MoviesResponseDto.toDomain() = Movie(
        id = id,
        title = title,
        img = img,
        classification = classification,
        schedule = schedule.map { it.toDomain() }
)

fun ScheduleDto.toDomain() = Schedule(
        time = time,
        paymentUrl = paymentUrl,
        price = price
)