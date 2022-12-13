package com.joelzhu.helper.acalculator.ui.activities

import android.app.Activity
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import com.joelzhu.helper.acalculator.R
import com.joelzhu.helper.acalculator.databinding.ActivityAddAssetBinding
import com.joelzhu.helper.acalculator.viewmodel.AddAssetViewModel
import com.joelzhu.helper.base.ui.BaseActivity

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-12-13
 */
class AddAssetActivity : BaseActivity<ActivityAddAssetBinding, AddAssetViewModel>(), View.OnClickListener, TextView.OnEditorActionListener {
    override fun doOnCreate() {
        binding!!.etDescription.setOnEditorActionListener(this)
        binding!!.etMoney.setOnEditorActionListener(this)
        binding!!.tvSaveAsset.setOnClickListener(this)
    }

    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId != EditorInfo.IME_ACTION_DONE) {
            return false
        }

        toAddAsset()
        return true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvSaveAsset -> toAddAsset()
        }
    }

    private fun toAddAsset() {
        if (TextUtils.isEmpty(binding!!.etMoney.text.toString())) {
            return
        }

        val money = binding!!.etMoney.text.toString().toLong()
        val description = binding!!.etDescription.text.toString()
        viewModel!!.addAsset(money, description) { result ->
            run {
                if (result) {
                    setResult(Activity.RESULT_OK)
                    finish()
                } else {
                    Toast.makeText(this@AddAssetActivity, getString(R.string.add_asset_failed), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}