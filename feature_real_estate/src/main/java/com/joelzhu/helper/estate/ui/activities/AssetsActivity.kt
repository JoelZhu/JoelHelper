package com.joelzhu.helper.estate.ui.activities

import android.view.View
import com.google.android.material.appbar.AppBarLayout
import com.joelzhu.helper.acalculator.databinding.ActivityAssetsBinding
import com.joelzhu.helper.base.ui.BaseActivity
import com.joelzhu.helper.estate.viewmodel.AssetsViewModel
import kotlin.math.abs

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-12-01
 */
class AssetsActivity : BaseActivity<ActivityAssetsBinding, AssetsViewModel>(), AppBarLayout.OnOffsetChangedListener {
    override fun doOnCreate() {
        binding!!.ablAssetsTool.addOnOffsetChangedListener(this)
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        val viewVisibility: Int = if (appBarLayout == null || abs(verticalOffset) < appBarLayout.totalScrollRange) {
            View.GONE
        } else {
            View.VISIBLE
        }
        binding!!.fabDoneAnchorBottom.visibility = viewVisibility
    }
}