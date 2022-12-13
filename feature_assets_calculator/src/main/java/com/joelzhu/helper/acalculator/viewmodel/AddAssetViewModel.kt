package com.joelzhu.helper.acalculator.viewmodel

import androidx.lifecycle.ViewModel
import com.joelzhu.helper.acalculator.database.DBService
import java.util.function.Consumer

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-12-01
 */
class AddAssetViewModel : ViewModel() {
    fun addAsset(money: Long, description: String, callback: Consumer<Boolean>) {
        DBService.updateDebtsInThread(money, description, callback = callback)
    }
}