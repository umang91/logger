package com.umang.logger.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SampleApp.logger.info(" onCreate() ")
        SampleApp.logger.error(" onCreate() ")
        SampleApp.logger.warn(" onCreate() ")
        SampleApp.logger.debug(" onCreate() ")
        SampleApp.logger.verbose(" onCreate() ")
    }
}