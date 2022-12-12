package com.joelzhu.helper.estate

import android.app.Application
import com.joelzhu.helper.estate.database.DBService

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-30
 */
class EstateApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        DBService.initialize(this@EstateApplication)
    }
}