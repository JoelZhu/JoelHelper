package com.joelzhu.helper.estate.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-30
 */
@Entity(tableName = DBHelper.ASSETS_TABLE)
class AssetsEntity(@PrimaryKey(autoGenerate = true) val assetsId: Int, val money: Long, val description: String)