package com.joelzhu.helper.acalculator.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.joelzhu.helper.acalculator.R
import com.joelzhu.helper.acalculator.database.AssetsEntity
import com.joelzhu.helper.acalculator.databinding.ItemAssetsListBinding
import com.joelzhu.helper.acalculator.viewmodel.AssetsListViewModel

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-30
 */
class AssetsListAdapter(private var viewModel: AssetsListViewModel) : RecyclerView.Adapter<AssetsListAdapter.ViewHolder>() {
    private var assets: Array<AssetsEntity> = arrayOf()

    class ViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemAssetsListBinding>(LayoutInflater.from(parent.context), R.layout.item_assets_list, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder.binding is ItemAssetsListBinding) {
            val listBinding: ItemAssetsListBinding = holder.binding
            listBinding.assetsEntity = assets[position]
            listBinding.viewModel = viewModel
        }
    }

    override fun getItemCount(): Int {
        return assets.size
    }

    fun updateAssets(assets: Array<AssetsEntity>) {
        this.assets = assets
    }
}