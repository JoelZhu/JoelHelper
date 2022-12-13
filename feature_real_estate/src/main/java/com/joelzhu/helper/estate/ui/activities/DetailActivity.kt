package com.joelzhu.helper.estate.ui.activities

import com.joelzhu.helper.acalculator.databinding.ActivityDetailBinding
import com.joelzhu.helper.base.ui.BaseActivity
import com.joelzhu.helper.estate.viewmodel.DetailViewModel

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-29
 */
class DetailActivity : BaseActivity<ActivityDetailBinding?, DetailViewModel?>() {
    override fun doOnCreate() {
        setSupportActionBar(binding!!.toolbarDetail)
        val toolBarLayout = binding!!.ctlDetail
        toolBarLayout.title = title
        binding!!.fab.setOnClickListener { }
    }
}