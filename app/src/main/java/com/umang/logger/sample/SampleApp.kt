package com.umang.logger.sample

import android.app.Application
import com.umang.logger.LogLevel
import com.umang.logger.Logger
import com.umang.logger.adapters.LogcatLogAdapter

/**
 * @author Umang Chamaria
 */
class SampleApp: Application() {

    override fun onCreate() {
        super.onCreate()
        logger = Logger.with("SampleApp", "", setOf(LogcatLogAdapter(LogLevel.NO_LOG)))
    }

    companion object {
        lateinit var logger: Logger
    }
}