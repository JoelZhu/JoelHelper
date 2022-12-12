package com.joelzhu.helper.estate.viewmodel

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.joelzhu.helper.estate.ui.activities.AddActivity
import com.joelzhu.helper.estate.ui.activities.AssetsActivity

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-24
 */
class ListViewModel : ViewModel() {
    fun toAddEstate(context: Context) {
        val intent = Intent(context, AddActivity::class.java)
        context.startActivity(intent)
    }

    fun toSelectEstate(context: Context, estateName: String) {
        Toast.makeText(context, estateName, Toast.LENGTH_SHORT).show()
    }

    fun onAssetsOptionSelected(context: Context) {
        context.startActivity(Intent(context, AssetsActivity::class.java))
    }
}