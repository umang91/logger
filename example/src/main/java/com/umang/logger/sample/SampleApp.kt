package com.umang.logger.sample

import android.app.Application
import dev.assemblage.logger.LogLevel
import dev.assemblage.logger.LogcatLogAdapter
import dev.assemblage.logger.Logger

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