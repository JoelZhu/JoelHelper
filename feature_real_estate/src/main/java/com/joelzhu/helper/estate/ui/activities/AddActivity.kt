package com.joelzhu.helper.estate.ui.activities

import com.joelzhu.helper.acalculator.databinding.ActivityAddBinding
import com.joelzhu.helper.base.ui.BaseActivity
import com.joelzhu.helper.estate.viewmodel.AddViewModel

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-29
 */
class AddActivity : BaseActivity<ActivityAddBinding?, AddViewModel?>() {
    override fun doOnCreate() {
        setSupportActionBar(binding!!.toolbar)
        val toolBarLayout = binding!!.toolbarLayout
        toolBarLayout.title = title
    }
}