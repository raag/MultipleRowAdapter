package com.raagpc.multiplerowadapter

import android.view.View
import android.view.ViewGroup

interface MultipleRowInterface {
    val type: Int
    fun bind(view: View)
    fun createViewHolder(parent: ViewGroup): MultipleRowAdapter.MultipleRowViewHolder
}