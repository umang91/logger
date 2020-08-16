package com.umang.logger.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author Umang Chamaria
 * Date: 2020/08/16
 */
public interface LogAdapter {
  /**
   * Used to determine whether log should be printed out or not.
   *
   * @param logLevel log level, i.e. VERBOSE, DEBUG, WARN, etc
   * @param logTag tag used for log message
   * @return true if message should be logged else false
   */
  boolean isLoggable(int logLevel, String logTag);

  /**
   * @param logLevel log level, i.e. VERBOSE, DEBUG, WARN, etc
   * @param tag tag used for log message
   * @param message Log message
   */
  void log(int logLevel, @Nullable String tag, @NonNull String message);
}
