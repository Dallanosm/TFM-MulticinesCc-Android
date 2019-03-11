package com.multicinescc.app.navigator

import android.content.Context
import com.multicinescc.app.view.activity.MovieDetailsActivity

/**
 * Navigator.
 */

fun navigateToMovieDetailScreen(context: Context, id: Long) {
    context.startActivity(MovieDetailsActivity.getCallingIntent(context, id))
}