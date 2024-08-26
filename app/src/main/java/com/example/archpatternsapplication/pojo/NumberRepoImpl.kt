package com.example.archpatternsapplication.pojo

class NumberRepoImpl : NumberRepo {
    override fun getNumbers(): NumberModel {
        return NumberModel(DBNumberData().getNumbers().fnum , DBNumberData().getNumbers().snum)
    }

    override fun getSubtractionResult(): Int {
        return getNumbers().fnum - getNumbers().snum
    }
}