package com.joelzhu.helper.estate.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.joelzhu.helper.estate.R
import com.joelzhu.helper.estate.databinding.ItemEstateListBinding
import com.joelzhu.helper.estate.viewmodel.ListViewModel

/**
 * [Description here].
 *
 * @author zhuqian
 * @since 2022-11-30
 */
class EstateListAdapter(private var estateNames: Array<String>, private var viewModel: ListViewModel) : RecyclerView.Adapter<EstateListAdapter.ViewHolder>() {
    init {
        estateNames = arrayOf("jy", "lh")
    }

    class ViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemEstateListBinding>(LayoutInflater.from(parent.context), R.layout.item_estate_list, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val estateName = estateNames[position]
        if (holder.binding is ItemEstateListBinding) {
            val listBinding: ItemEstateListBinding = holder.binding
            listBinding.estateName = estateName
            listBinding.viewModel = viewModel
        }
    }

    override fun getItemCount(): Int {
        return estateNames.size
    }
}