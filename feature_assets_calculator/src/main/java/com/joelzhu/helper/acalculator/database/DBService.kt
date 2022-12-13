package com.joelzhu.helper.acalculator.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.function.Consumer

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
            val assetsEntity = AssetsEntity(AssetsEntity.EXISTING_MONEY, 0, "")
            initializeInThread(assetsEntity)
        }

        fun updateExistMoneyInThread(money: Long) {
            CoroutineScope(Dispatchers.IO).launch {
                instance.assetsDao().updateExistMoney(money)
            }
        }

        fun queryExistMoneyInThread() {
            CoroutineScope(Dispatchers.IO).launch {
                instance.assetsDao().queryExistMoney()
            }
        }

        fun updateDebtsInThread(money: Long, description: String = "", assetsId: Int = 0, callback: Consumer<Boolean>? = null) {
            CoroutineScope(Dispatchers.IO).launch {
                val updateResult = instance.assetsDao().updateDebts(AssetsEntity(assetsId, money, description))
                withContext(Dispatchers.Main) {
                    callback?.accept(updateResult > 0)
                }
            }
        }

        fun queryDebtsInThread(callback: Consumer<Array<AssetsEntity>>) {
            CoroutineScope(Dispatchers.IO).launch {
                val debts = instance.assetsDao().queryDebts()
                withContext(Dispatchers.Main) {
                    callback.accept(debts)
                }
            }
        }

        fun queryAssetsInThread(callback: Consumer<Array<AssetsEntity>>) {
            CoroutineScope(Dispatchers.IO).launch {
                val assetsArrayList = ArrayList<AssetsEntity>()
                assetsArrayList.addAll(instance.assetsDao().queryAssets())
                assetsArrayList.forEach {
                    if (it.assetsId == AssetsEntity.EXISTING_MONEY) {
                        assetsArrayList.remove(it)
                        assetsArrayList.add(0, it)
                    }
                }
                val assetsArray: Array<AssetsEntity> = assetsArrayList.toArray(arrayOf())
                withContext(Dispatchers.Main) {
                    callback.accept(assetsArray)
                }
            }
        }

        private fun initializeInThread(assetsEntity: AssetsEntity) {
            CoroutineScope(Dispatchers.IO).launch {
                instance.assetsDao().initialize(assetsEntity)
            }
        }
    }
}