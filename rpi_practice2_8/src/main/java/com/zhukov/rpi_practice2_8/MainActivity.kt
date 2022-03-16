package com.zhukov.rpi_practice2_8

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.zhukov.rpi_practice2_8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val solutionName = resources.getStringArray(R.array.SolutionName)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, solutionName)
        binding.spinner.adapter = adapter

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        getSolution(solutionName)

        observeViewModel()
    }

    private fun getSolution(solutionName: Array<String>) {
        binding.spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.getSolution.setOnClickListener {
                    try {
                        viewModel.getSolution(binding, solutionName[p2])
                    } catch (e: NumberFormatException) {
                        Toast.makeText(
                            applicationContext,
                            "Неверный формат числа, или не все поля заполнены!",
                            LENGTH_SHORT
                        ).show()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    private fun observeViewModel() {
        viewModel.solution.observe(this) {
            binding.solution.text = it.toString()
        }
    }
}