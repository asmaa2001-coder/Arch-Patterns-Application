package com.example.archpatternsapplication.pojo

interface NumberRepo {
    fun getNumbers():NumberModel
    fun getSubtractionResult():Int
}