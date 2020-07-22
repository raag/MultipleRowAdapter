package com.raagpc.multiplerowadapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.ViewDataBinding

class MultipleRowAdapter(
    private var dataSet: MutableList<MultipleRowInterface> = mutableListOf()
): RecyclerView.Adapter<MultipleRowAdapter.MultipleRowViewHolder>() {

    private var rowTypes = HashMap<Int, MultipleRowInterface>()

    init {
        dataSet.forEach {
            rowTypes[it.type] = it
        }
    }

    open class MultipleRowViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        open fun bind(row: MultipleRowInterface) {
            row.bind(view)
        }
    }

    class MultipleRowBindingViewHolder(private val mBinding: ViewDataBinding): MultipleRowViewHolder(mBinding.root) {
        override fun bind(row: MultipleRowInterface) {
            row.bind(mBinding)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultipleRowViewHolder {
        return rowTypes[viewType]!!.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MultipleRowViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    fun addRow(row: MultipleRowInterface) {
        rowTypes[row.type] = row
        dataSet.add(row)
    }

    fun updateRows(rows: MutableList<MultipleRowInterface>) {
        this.dataSet = rows
        rowTypes = HashMap()
        dataSet.forEach {
            rowTypes[it.type] = it
        }
    }

    override fun getItemViewType(position: Int): Int {
        return dataSet[position].type
    }
}
