package com.umang.logger

import android.util.Log

/**
 * @author Umang Chamaria
 * Date: 2020/08/16
 */
public class Logger(
    private val tag: String,
    @LogLevel private val logLevel: Int = LogLevel.VERBOSE,
    private val subTag: String = ""
) {

    public fun verbose(message: String) {
        if (shouldLog(LogLevel.VERBOSE)) Log.v(tag, subTag + message)
    }

    public fun verbose(message: String, throwable: Throwable?) {
        if (shouldLog(LogLevel.VERBOSE)) Log.v(tag, subTag + message, throwable)
    }

    public fun debug(message: String) {
        if (shouldLog(LogLevel.DEBUG)) Log.d(tag, subTag + message)
    }

    public fun debug(message: String, throwable: Throwable?) {
        if (shouldLog(LogLevel.DEBUG)) Log.d(tag, subTag + message, throwable)
    }

    public fun info(message: String) {
        if (shouldLog(LogLevel.INFO)) Log.i(tag, subTag + message)
    }

    public fun info(message: String, throwable: Throwable?) {
        if (shouldLog(LogLevel.INFO)) Log.i(tag, subTag + message, throwable)
    }

    public fun warn(message: String) {
        if (shouldLog(LogLevel.WARN)) Log.w(tag, subTag + message)
    }

    public fun warn(message: String, throwable: Throwable?) {
        if (shouldLog(LogLevel.WARN)) Log.w(tag, subTag + message, throwable)
    }

    public fun error(message: String) {
        if (shouldLog(LogLevel.ERROR)) Log.e(tag, subTag + message)
    }

    public fun error(message: String, throwable: Throwable?) {
        if (shouldLog(LogLevel.ERROR)) Log.e(tag, subTag + message, throwable)
    }

    private fun shouldLog(currentLevel: Int): Boolean {
        return currentLevel >= logLevel
    }

    public companion object {

        @JvmStatic
        public fun with(tag: String): Logger {
            return Logger(tag)
        }

        @JvmStatic
        public fun with(tag: String, @LogLevel logLevel: Int): Logger {
            return Logger(tag, logLevel)
        }

        @JvmStatic
        public fun with(tag: String, @LogLevel logLevel: Int, subTag: String): Logger {
            return Logger(tag, logLevel, subTag)
        }

    }
}