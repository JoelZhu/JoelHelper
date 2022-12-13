package com.joelzhu.helper.estate.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-30
 */
@Database(entities = [AssetsEntity::class], version = DBHelper.DB_VERSION, exportSchema = false)
abstract class DBService : RoomDatabase() {
    abstract fun assetsDao(): IAssetsDAO

    companion object {
        private lateinit var instance: DBService

        fun initialize(application: Application) {
            instance = Room.databaseBuilder(application, DBService::class.java, DBHelper.DB_NAME).build()
            val assetsEntity = AssetsEntity(1, 0, "")
            initializeInThread(assetsEntity)
        }

        fun initializeInThread(assetsEntity: AssetsEntity) {
            runBlocking {
                withContext(Dispatchers.IO) {
                    instance.assetsDao().initialize(assetsEntity)
                }
            }
        }

        fun updateExistMoneyInThread(money: Long) {
            runBlocking {
                withContext(Dispatchers.IO) {
                    instance.assetsDao().updateExistMoney(money)
                }
            }
        }

        fun updateDebtMoneyInThread(assetsId: Int = 0, money: Long, description: String) {
            runBlocking {
                withContext(Dispatchers.IO) {
                    instance.assetsDao().updateDebtMoney(AssetsEntity(assetsId, money, description))
                }
            }
        }
    }
}