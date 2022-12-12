package com.joelzhu.helper.estate.ui.activities

import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.joelzhu.helper.estate.R
import com.joelzhu.helper.estate.databinding.ActivityListBinding
import com.joelzhu.helper.estate.ui.adapters.EstateListAdapter
import com.joelzhu.helper.base.ui.BaseActivity
import com.joelzhu.helper.estate.viewmodel.ListViewModel

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-29
 */
class ListActivity : BaseActivity<ActivityListBinding?, ListViewModel?>() {
    override fun doOnCreate() {
        binding!!.viewModel = viewModel
        setSupportActionBar(binding!!.toolbar)

        val adapter = EstateListAdapter(arrayOf(), viewModel!!)
        binding!!.rvEstateList.layoutManager = LinearLayoutManager(this)
        binding!!.rvEstateList.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else if (id == R.id.action_assets) {
            viewModel!!.onAssetsOptionSelected(this)
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}