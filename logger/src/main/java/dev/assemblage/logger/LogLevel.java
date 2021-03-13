package dev.assemblage.logger;

import androidx.annotation.IntDef;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Supported Log levels
 *
 * @author Umang Chamaria
 */
@Retention(SOURCE)
@IntDef({
    LogLevel.NO_LOG, LogLevel.ERROR, LogLevel.WARN, LogLevel.INFO, LogLevel.DEBUG, LogLevel.VERBOSE
})
public @interface LogLevel {
  /**
   * No logs would be printed.
   */
  int NO_LOG = 0;
  /**
   * Error logs would be printed.
   */
  int ERROR = 1;
  /**
   * Warning logs would be printed.
   */
  int WARN = 2;
  /**
   * Info logs would be printed.
   */
  int INFO = 3;
  /**
   * Debug logs would be printed.
   */
  int DEBUG = 4;
  /**
   * Verbose logs would be printed.
   */
  int VERBOSE = 5;
}
