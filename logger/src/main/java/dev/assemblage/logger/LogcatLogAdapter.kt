package dev.assemblage.logger

import android.util.Log
import dev.assemblage.logger.adapters.LogAdapter

/**
 * Adapter to print logs to the logcat window.
 * @author Umang Chamaria
 */
public open class LogcatLogAdapter(@LogLevel private val logLevel: Int): LogAdapter {
    override fun isLoggable(logLevel: Int): Boolean {
        return this.logLevel >= logLevel
    }

    override fun log(
        @LogLevel logLevel: Int,
        tag: String,
        subTag: String,
        message: String,
        throwable: Throwable?
    ) {

        when(logLevel) {
            LogLevel.NO_LOG -> {

            }
            LogLevel.ERROR -> {
                Log.e(tag, "$subTag $message", throwable)
            }
            LogLevel.WARN -> {
                Log.w(tag, "$subTag $message", throwable)
            }
            LogLevel.INFO -> {
                Log.i(tag, "$subTag $message", throwable)
            }
            LogLevel.DEBUG -> {
                Log.d(tag, "$subTag $message", throwable)
            }
            LogLevel.VERBOSE -> {
                logVerbose(tag, subTag, message)
            }
        }
    }

    private fun logVerbose(tag: String, subTag: String, message: String) {
        if (message.length > 4000) {
            Log.v(tag, "$subTag ${message.substring(0, 4000)}")
            logVerbose(tag, subTag, message.substring(4000))
        } else {
            Log.v(tag, "$subTag $message")
        }
    }

}