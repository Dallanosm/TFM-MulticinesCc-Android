package com.multicinescc.data.mappers

import com.multicinescc.data.models.*
import com.multicinescc.domain.models.*
import java.util.*

fun MoviesResponseDto.toDomain() = Movie(
        id = id,
        title = title,
        img = img,
        classification = if (classification.length <= 4) {
            classification
        } else {
            if (classification.toLowerCase().contains("apta")) {
                "Apta" //Fixme
            } else {
                classification.split(",")[0]
            }
        },
        schedule = schedule.map { it.toDomain() }
)

fun ScheduleDto.toDomain() = Schedule(
        time = time,
        paymentUrl = paymentUrl,
        price = price
)

fun MovieDetailDto.toDomain() = MovieDetail(
        title = title,
        image = image,
        country = country,
        year = year,
        duration = duration,
        director = director,
        releaseDate = releaseDate,
        classification = if (classification.length <= 4) {
            classification
        } else {
            if (classification.toLowerCase().contains("apta")) {
                "Apta" //Fixme
            } else {
                classification.split(",")[0]
            }
        },
        cast = cast.map { it.toDomain() },
        sinopsis = sinopsis,
        trailer = trailer,
        tickets = tickets.map { it.toDomain() }
)

fun CastDto.toDomain() = Actor(
        name = name,
        image = image
)

fun MoviesCommentDto.toDomain() = Comment(
        id = id,
        createdDate = Date(createdDate),
        value = value
)