package com.joelzhu.helper.base.util

import android.util.Log
import androidx.annotation.StringDef

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-24
 */
object LogUtil {
    private const val MAIN_TAG = "Joel->"
    fun d(@LogType logType: String, logContent: String?) {
        Log.d(MAIN_TAG + logType, logContent!!)
    }

    fun v(@LogType logType: String, logContent: String?) {
        Log.v(MAIN_TAG + logType, logContent!!)
    }

    fun i(@LogType logType: String, logContent: String?) {
        Log.i(MAIN_TAG + logType, logContent!!)
    }

    fun w(@LogType logType: String, logContent: String?) {
        Log.w(MAIN_TAG + logType, logContent!!)
    }

    fun e(@LogType logType: String, logContent: String?) {
        Log.e(MAIN_TAG + logType, logContent!!)
    }

    @StringDef(LogType.MAIN)
    @Retention(AnnotationRetention.SOURCE)
    annotation class LogType {
        companion object {
            const val MAIN = "Main"
        }
    }
}