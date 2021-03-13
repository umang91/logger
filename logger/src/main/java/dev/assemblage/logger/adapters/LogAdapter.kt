package dev.assemblage.logger.adapters

import dev.assemblage.logger.LogLevel

/**
 * Adapter class to extend logging
 * @author Umang Chamaria
 */
public interface LogAdapter {

    /**
     * Used to determine whether log should be printed out or not.
     *
     * @param logLevel log level, i.e. VERBOSE, DEBUG, WARN, etc
     * @return true if message should be logged else false
     */
    public fun isLoggable(@LogLevel logLevel: Int): Boolean

    /**
     * Logs the message.
     *
     * @param logLevel log level, i.e. VERBOSE, DEBUG, WARN, etc
     * @param tag tag used for log message
     * @param message Log message
     * @param throwable instance of [Throwable]
     */
    public fun log(
        @LogLevel logLevel: Int,
        tag: String,
        subTag: String,
        message: String,
        throwable: Throwable?
    )
}