package com.umang.logger;

import androidx.annotation.IntDef;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * @author Umang Chamaria
 * Date: 2020/08/16
 */
@Retention(SOURCE)
@IntDef({
    LogLevel.NO_LOG, LogLevel.ERROR, LogLevel.WARN, LogLevel.INFO, LogLevel.DEBUG, LogLevel.VERBOSE
})
public @interface LogLevel {
  int NO_LOG = 0;
  int ERROR = 1;
  int WARN = 2;
  int INFO = 3;
  int DEBUG = 4;
  int VERBOSE = 5;
}
