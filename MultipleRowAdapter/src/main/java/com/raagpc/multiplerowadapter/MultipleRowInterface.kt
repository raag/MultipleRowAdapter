package com.raagpc.multiplerowadapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

interface MultipleRowInterface {
    val type: Int
    fun bind(view: View) {}
    fun bind(binding: ViewDataBinding) {}
    fun createViewHolder(parent: ViewGroup): MultipleRowAdapter.MultipleRowViewHolder
}