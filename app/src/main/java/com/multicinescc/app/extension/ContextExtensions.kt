package com.multicinescc.app.extension

import android.content.Context
import android.widget.ImageView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * ContextExtensions
 */

/**
 * Context
 * */
fun Context.toast(text: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, text, length).show()
}

fun Context.toast(textId: Int, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, textId, length).show()
}

fun Context.toPx(dp: Int): Int = resources.getDimensionPixelSize(dp)

fun ImageView.tint(@ColorRes color: Int) {
    this.setColorFilter(ContextCompat.getColor(context, color), android.graphics.PorterDuff.Mode.SRC_IN)
}

/**
 * Fragments
 * */
fun Fragment.toast(text: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(activity, text, length).show()
}

fun Fragment.toast(textId: Int, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(activity, textId, length).show()
}
