package com.example.archpatternsapplication.ui

import com.example.archpatternsapplication.pojo.NumberRepo

class NumberPresenter( private val repo: NumberRepo) {
    fun onButtonClickedSubtraction() :Int{
        val result = repo.getSubtractionResult()
        return result
    }
}