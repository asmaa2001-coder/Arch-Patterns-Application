package com.example.archpatternsapplication.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.archpatternsapplication.databinding.ActivityMainBinding
import com.example.archpatternsapplication.pojo.DBNumberData
import com.example.archpatternsapplication.pojo.NumberRepoImpl
import com.example.archpatternsapplication.viewmodel.NumberViewModel

class MainActivity : AppCompatActivity() , NumberView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: NumberPresenter
    private val numberViewModel: NumberViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = NumberPresenter(NumberRepoImpl())

        //for MVVM
        numberViewModel.numbers.observe(this) { numbers ->
            binding.num1.text = numbers.fnum.toString()
            binding.num2.text = numbers.snum.toString()
        }

        numberViewModel.result.observe(this) { result ->
            binding.plusResult.text = result.toString()

        }
        binding.plus.setOnClickListener {

              numberViewModel.setAddition()


        }

        //for mvp
        binding.minus.setOnClickListener { displayResult() }

        //for mvc
        binding.multi.setOnClickListener {
            val result = DBNumberData().getNumbers().fnum * DBNumberData().getNumbers().snum
            binding.multiResult.text = result.toString()

        }

    }

    override fun displayResult() {
        binding.minusResult.text = presenter.onButtonClickedSubtraction().toString()
    }


}