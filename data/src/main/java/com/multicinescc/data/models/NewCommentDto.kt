package com.multicinescc.data.models

import com.google.gson.annotations.SerializedName


data class NewCommentDto(
        @SerializedName("value") val value: String
)