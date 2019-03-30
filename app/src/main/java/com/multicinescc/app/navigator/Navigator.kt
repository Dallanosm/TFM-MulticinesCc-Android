package com.multicinescc.app.navigator

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.multicinescc.app.view.activity.MovieDetailsActivity


/**
 * Navigator.
 */

fun navigateToMovieDetailScreen(context: Context, id: Long) {
    context.startActivity(MovieDetailsActivity.getCallingIntent(context, id))
}

fun openVideo(context: Context, videoURL: String) {
    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(videoURL)))
}