package com.joelzhu.helper.estate.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-30
 */
@Dao
interface IAssetsDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun initialize(assetsEntity: AssetsEntity)

    @Query("UPDATE " + DBHelper.ASSETS_TABLE + " SET money=:money WHERE assetsId=1")
    fun updateExistMoney(money: Long)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateDebtMoney(assetsEntity: AssetsEntity)
}