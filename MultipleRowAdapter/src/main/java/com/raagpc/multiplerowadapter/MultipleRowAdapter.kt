package com.raagpc.multiplerowadapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.ViewDataBinding

class MultipleRowAdapter(
    private val recyclerView: RecyclerView,
    private var dataSet: MutableList<MultipleRowInterface> = mutableListOf(),
    private val listener: RowAdapterListener? = null
): RecyclerView.Adapter<MultipleRowAdapter.MultipleRowViewHolder>() {

    private val rowTypes = HashMap<Int, MultipleRowInterface>()

    interface RowAdapterListener {
        fun onScrollToBottom()
    }

    init {
        dataSet.forEach {
            rowTypes[it.type] = it
        }
        setupEvents()
    }

    private fun setupEvents( ) {
        setupOnScrollToBottom()
    }

    private fun setupOnScrollToBottom(deltaRows: Int = 0) {
        val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
        recyclerView.addOnScrollListener( object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                linearLayoutManager?.let {
                    val totalItemCount = it.itemCount
                    val lastVisibleItem = it.findLastVisibleItemPosition()
                    if (totalItemCount <= lastVisibleItem + deltaRows){
                        listener?.onScrollToBottom()
                    }
                }
            }
        })
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
        dataSet.forEach {
            rowTypes[it.type] = it
        }
    }

    override fun getItemViewType(position: Int): Int {
        return dataSet[position].type
    }
}
