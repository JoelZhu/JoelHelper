package com.joelzhu.helper.acalculator.ui.activities

import android.app.Activity
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.joelzhu.helper.acalculator.databinding.ActivityAssetsListBinding
import com.joelzhu.helper.acalculator.ui.adapters.AssetsListAdapter
import com.joelzhu.helper.acalculator.viewmodel.AssetsListViewModel
import com.joelzhu.helper.base.ui.BaseActivity
import com.joelzhu.helper.base.util.LogUtil

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-12-01
 */
class AssetsListActivity : BaseActivity<ActivityAssetsListBinding, AssetsListViewModel>(), SwipeRefreshLayout.OnRefreshListener {
    companion object {
        const val REQUEST_CODE_ADD = 1
    }

    private lateinit var adapter: AssetsListAdapter

    override fun doOnCreate() {
        adapter = AssetsListAdapter(viewModel!!)
        binding!!.viewModel = viewModel
        binding!!.rvAssets.layoutManager = LinearLayoutManager(this)
        binding!!.rvAssets.adapter = adapter
        binding!!.srlAssets.setOnRefreshListener(this)

        initializeAssetsData()
    }

    override fun onRefresh() {
        initializeAssetsData()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode != Activity.RESULT_OK) {
            return
        }

        when (requestCode) {
            REQUEST_CODE_ADD -> initializeAssetsData()
        }
    }

    private fun initializeAssetsData() {
        viewModel!!.initializeAssets { assets ->
            run {
                LogUtil.d("Test", "initializeAssetsData")
                adapter.updateAssets(assets)
                adapter.notifyDataSetChanged()
                binding!!.srlAssets.isRefreshing = false
            }
        }
    }
}