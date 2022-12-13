package com.joelzhu.helper.estate.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.joelzhu.helper.acalculator.R
import com.joelzhu.helper.estate.database.AssetsEntity
import com.joelzhu.helper.acalculator.databinding.ItemDebtListBinding

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-30
 */
class DebtListAdapter(private var assets: Array<AssetsEntity>) : RecyclerView.Adapter<DebtListAdapter.ViewHolder>() {
    class ViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemDebtListBinding>(LayoutInflater.from(parent.context), R.layout.item_debt_list, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val asset = assets[position]
        if (holder.binding is ItemDebtListBinding) {
            val listBinding: ItemDebtListBinding = holder.binding
            listBinding.tvDebtAssetDescription.text = asset.description
            listBinding.tvDebtAssetMoney.text = asset.money.toString()
        }
    }

    override fun getItemCount(): Int {
        return assets.size
    }
}