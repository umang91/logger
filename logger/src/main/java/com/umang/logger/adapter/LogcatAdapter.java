package com.umang.logger.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author Umang Chamaria
 * Date: 2020/08/16
 */
public class LogcatAdapter implements LogAdapter{
  @Override public boolean isLoggable(int logLevel, String logTag) {
    return false;
  }

  @Override public void log(int logLevel, @Nullable String tag, @NonNull String message) {

  }
}
