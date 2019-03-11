package com.multicinescc.app.error

/**
 * ErrorHandler.
 */
interface ErrorHandler {
    fun convert(e: Exception): String
}
