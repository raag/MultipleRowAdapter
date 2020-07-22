package com.raagpc.multiplerowadaptertest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import com.raagpc.multiplerowadapter.MultipleRowAdapter
import com.raagpc.multiplerowadapter.MultipleRowInterface
import com.raagpc.multiplerowadaptertest.databinding.AdapterType1Binding

class RowType1(private val titleText: String, override val type: Int): MultipleRowInterface {

    private lateinit var title: TextView

    override fun bind(binding: ViewDataBinding) {
        val mBinding = binding as AdapterType1Binding
        val view = mBinding.root
        title = view.findViewById(R.id.title)

        title.text = titleText
    }

    override fun createViewHolder(parent: ViewGroup): MultipleRowAdapter.MultipleRowViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.adapter_type_1, parent, false) as View

        return MultipleRowAdapter.MultipleRowViewHolder(view)
    }
}