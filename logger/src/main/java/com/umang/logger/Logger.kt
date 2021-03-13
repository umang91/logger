package com.umang.logger

import java.util.*
import android.util.Log

/**
 * @author Umang Chamaria
 */
public class Logger private constructor(
    private val tag: String,
    private val subTag: String = "",
    logAdapters: Set<LogAdapter>
) {

    private val adapters = Collections.synchronizedSet(mutableSetOf<LogAdapter>())

    init {
        adapters.addAll(logAdapters)
    }

    /**
     * Adds an instance of [LogAdapter]
     * @param adapter instance [LogAdapter]
     * @since 1.0.0
     */
    @Suppress("SENSELESS_COMPARISON")
    public fun addAdapter(adapter: LogAdapter) {
        try {
            if (adapter != null) {
                adapters.add(adapter)
            }
        } catch (e: Exception) {
        }
    }

    /**
     * Remove the passed instance of [LogAdapter]
     * @param adapter instance of [LogAdapter]
     * @since 1.0.0
     */
    @Suppress("SENSELESS_COMPARISON")
    public fun removeAdapter(adapter: LogAdapter) {
        try {
            if (adapter != null) {
                adapters.remove(adapter)
            }
        } catch (e: Exception) {
        }
    }

    /**
     * Adds the [Set] of adapters to the current instance
     * @param adapters [Set] of [LogAdapter]
     * @since 1.0.0
     */
    public fun addAdapters(adapters: Set<LogAdapter>) {
        try {
            this.adapters.addAll(adapters)
        } catch (e: Exception) {
        }
    }

    /**
     * Prints verbose logs.
     *
     * @param message Message to be printed.
     * @since 1.0.0
     */
    public fun verbose(message: String) {
        log(LogLevel.VERBOSE, tag, subTag, message, null)
    }

    /**
     * Prints debug logs.
     *
     * @param message Message to be printed.
     * @since 1.0.0
     */
    public fun debug(message: String) {
        log(LogLevel.DEBUG, tag, subTag, message, null)
    }

    /**
     * Prints info logs.
     *
     * @param message Message to be printed.
     * @since 1.0.0
     */
    public fun info(message: String) {
        log(LogLevel.INFO, tag, subTag, message, null)
    }

    /**
     * Prints warning logs.
     *
     * @param message Message to be printed.
     * @since 1.0.0
     */
    public fun warn(message: String) {
        log(LogLevel.WARN, tag, subTag, message, null)
    }

    /**
     * Prints error logs.
     *
     * @param message Message to be printed.
     * @since 1.0.0
     */
    public fun error(message: String) {
        log(LogLevel.ERROR, tag, subTag, message, null)
    }

    /**
     * Prints error logs.
     *
     * @param message Message to be printed.
     * @param throwable instance of [Throwable]
     * @since 1.0.0
     */
    public fun error(message: String, throwable: Throwable?) {
        log(LogLevel.ERROR, tag, subTag, message, throwable)
    }

    private fun log(logLevel: Int, tag: String, subTag: String, message: String, throwable:
    Throwable?) {
        try {
            synchronized(adapters) {
                for (adapter in adapters) {
                    if (adapter.isLoggable(logLevel)) {
                        adapter.log(logLevel, tag, subTag, message, throwable)
                    }
                }
            }
        } catch (e: Exception) {
        }
    }

    public companion object {

        /**
         * Helper method to create an instance of [Logger]
         *
         * @param tag Tag for each log
         * @return instance [Logger]
         * @since 1.0.0
         */
        @JvmStatic
        public fun with(tag: String): Logger {
            return Logger(tag, "", emptySet())
        }

        /**
         * Helper method to create an instance of [Logger]
         *
         * @param tag Tag for each log
         * @param adapters [Set] of adapters of type [LogAdapter]
         * @return instance [Logger]
         * @since 1.0.0
         */
        @JvmStatic
        public fun with(tag: String, adapters: Set<LogAdapter>): Logger {
            return Logger(tag, "", adapters)
        }

        /**
         * Helper method to create an instance of [Logger]
         *
         * @param tag Tag for each log
         * @param subTag Sub Tag for each log
         * @return instance [Logger]
         * @since 1.0.0
         */
        @JvmStatic
        public fun with(tag: String, subTag: String): Logger {
            return Logger(tag, subTag, emptySet())
        }

        /**
         * Helper method to create an instance of [Logger]
         *
         * @param tag Tag for each log
         * @param subTag Sub Tag for each log
         * @param adapters [Set] of adapters of type [LogAdapter]
         * @return instance [Logger]
         * @since 1.0.0
         */
        @JvmStatic
        public fun with(tag: String, subTag: String, adapters: Set<LogAdapter>): Logger {
            return Logger(tag, subTag, adapters)
        }

    }

}