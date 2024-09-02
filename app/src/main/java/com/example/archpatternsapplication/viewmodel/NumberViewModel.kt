package com.example.archpatternsapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.archpatternsapplication.pojo.DBNumberData
import com.example.archpatternsapplication.pojo.NumberModel

class NumberViewModel : ViewModel() {
    private val _numbers = MutableLiveData<NumberModel>()
    val numbers: MutableLiveData<NumberModel> get() = _numbers

    private val _result = MutableLiveData<Int>()
    val result: MutableLiveData<Int> get() = _result

    val num = DBNumberData().getNumbers()


    init {
        getNumbers()
    }

    fun setAddition() {
        _result.value = (num.fnum + num.snum)
    }

    private fun getNumbers() {
        _numbers.value = num

    }


}