package com.joelzhu.helper.acalculator.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-30
 */
@Entity(tableName = DBHelper.ASSETS_TABLE)
class AssetsEntity(@PrimaryKey(autoGenerate = true) val assetsId: Int, val money: Long, val description: String) {
    companion object {
        const val EXISTING_MONEY = 1
    }

    fun isExistingMoney(): Boolean {
        return assetsId == EXISTING_MONEY
    }
}