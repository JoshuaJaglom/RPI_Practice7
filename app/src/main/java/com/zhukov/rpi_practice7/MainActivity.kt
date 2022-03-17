package com.zhukov.rpi_practice7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zhukov.rpi_practice7.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        setValue()
        observeViewModel()
    }

    fun setValue() {
        binding.button?.setOnClickListener {
            val editTextValue = binding.editText?.text.toString()
            val checkBoxValue: String = if (binding.checkbox?.isChecked == true) "ON" else "OFF"
            val toggleButtonValue: String = binding.toggleButton?.text.toString()
            val radioButtonValue: String = if (binding.radioButton?.isChecked == true)
                binding.radioButton!!.text.toString()
            else binding.radioButton2!!.text.toString()
            viewModel.setValue(editTextValue, checkBoxValue, toggleButtonValue, radioButtonValue)
        }
    }

    private fun observeViewModel() {
        viewModel.msg.observe(this, Observer {
            binding.textView?.text  = it
        })
    }
}