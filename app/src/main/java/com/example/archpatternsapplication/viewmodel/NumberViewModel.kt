package com.example.archpatternsapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.archpatternsapplication.pojo.DBNumberData
import com.example.archpatternsapplication.pojo.NumberModel

class NumberViewModel : ViewModel() {
    private val mutableLiveDataNum = MutableLiveData<NumberModel>()
    val numbers: MutableLiveData<NumberModel> get() = mutableLiveDataNum

    private val mutableLiveDataResult = MutableLiveData<Int>()
    val result: MutableLiveData<Int> get() = mutableLiveDataResult

    val num = DBNumberData().getNumbers()


    init {
        getNumbers()
    }

    fun setAddition() {
        val result = num.fnum + num.snum
        mutableLiveDataResult.value = result
    }

    private fun getNumbers() {
        mutableLiveDataNum.value = num

    }


}