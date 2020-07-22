package com.raagpc.multiplerowadaptertest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raagpc.multiplerowadapter.MultipleRowAdapter

class MainViewModel: ViewModel() {

    val adapter = MutableLiveData<MultipleRowAdapter>()

    fun initAdapter() {
        val rowType1 = 1
        val rowType2 = 2
        adapter.value = MultipleRowAdapter()
        adapter.value?.addRow( RowType1("test1", rowType1) )
        adapter.value?.addRow( RowType2("test2", rowType2) )
        adapter.value?.addRow( RowType2("test3", rowType2) )
        adapter.value?.addRow( RowType1("test4", rowType1) )
        adapter.value?.addRow( RowType1("test1", rowType1) )
        adapter.value?.addRow( RowType2("test2", rowType2) )
        adapter.value?.addRow( RowType2("test3", rowType2) )
        adapter.value?.addRow( RowType1("test4", rowType1) )
        adapter.value?.addRow( RowType1("test4", rowType1) )
        adapter.value?.addRow( RowType1("test4", rowType1) )
        adapter.value?.addRow( RowType1("test4", rowType1) )
        adapter.value?.addRow( RowType1("test4", rowType1) )
        adapter.value?.addRow( RowType2("test3", rowType2) )
        adapter.value?.addRow( RowType2("test3", rowType2) )
        adapter.value?.addRow( RowType2("test3", rowType2) )
        adapter.value?.addRow( RowType2("test3", rowType2) )
        adapter.value?.notifyDataSetChanged()
    }
}