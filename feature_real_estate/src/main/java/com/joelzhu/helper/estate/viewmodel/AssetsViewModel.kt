package com.joelzhu.helper.estate.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.joelzhu.helper.estate.database.DBService

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-12-01
 */
class AssetsViewModel : ViewModel() {
    companion object {
        val existingMoneyOF: ObservableField<Long> = ObservableField()

        val availableDebtOF: ObservableField<Map<Int, Long>> = ObservableField()
    }

    fun onAssetsEditDone() {
        existingMoneyOF.get()?.let { DBService.updateExistMoneyInThread(it) }
        availableDebtOF.get()?.forEach { (debtId, debtMoney) ->  }
    }
}