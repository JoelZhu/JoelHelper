package com.joelzhu.helper.acalculator

import android.app.Application
import com.joelzhu.helper.acalculator.database.DBService

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-30
 */
class AssetsCalculatorApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        DBService.initialize(this@AssetsCalculatorApplication)
    }
}