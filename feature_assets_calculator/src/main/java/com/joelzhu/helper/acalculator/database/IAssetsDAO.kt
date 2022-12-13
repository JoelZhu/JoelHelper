package com.joelzhu.helper.acalculator.database

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

    @Query("UPDATE " + DBHelper.ASSETS_TABLE + " SET money=:money WHERE assetsId=" + AssetsEntity.EXISTING_MONEY)
    fun updateExistMoney(money: Long)

    @Query("SELECT money FROM " + DBHelper.ASSETS_TABLE + " WHERE assetsId=" + AssetsEntity.EXISTING_MONEY)
    fun queryExistMoney(): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateDebts(assetsEntity: AssetsEntity): Long

    @Query("SELECT * FROM " + DBHelper.ASSETS_TABLE + " WHERE assetsId!=" + AssetsEntity.EXISTING_MONEY)
    fun queryDebts(): Array<AssetsEntity>

    @Query("SELECT * FROM " + DBHelper.ASSETS_TABLE + " ORDER BY money DESC")
    fun queryAssets(): Array<AssetsEntity>
}