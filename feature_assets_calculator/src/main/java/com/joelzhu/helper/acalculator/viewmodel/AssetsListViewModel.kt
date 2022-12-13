package com.joelzhu.helper.acalculator.viewmodel

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.joelzhu.helper.acalculator.R
import com.joelzhu.helper.acalculator.database.AssetsEntity
import com.joelzhu.helper.acalculator.database.DBService
import com.joelzhu.helper.acalculator.ui.activities.AddAssetActivity
import com.joelzhu.helper.acalculator.ui.activities.AssetsListActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.function.Consumer

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-12-01
 */
class AssetsListViewModel : ViewModel() {
    fun initializeAssets(callback: Consumer<Array<AssetsEntity>>) {
        CoroutineScope(Dispatchers.IO).launch {
            DBService.queryAssetsInThread(callback)
        }
    }

    fun toAddAsset(context: Context) {
        context as Activity
        val intent = Intent(context, AddAssetActivity::class.java)
        context.startActivityForResult(intent, AssetsListActivity.REQUEST_CODE_ADD)
    }

    fun getAssetsMoney(context: Context, assetsEntity: AssetsEntity): String {
        return if (assetsEntity.isExistingMoney()) {
            context.getString(R.string.real_asset)
        } else {
            assetsEntity.description
        }
    }
}