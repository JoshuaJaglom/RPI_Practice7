package com.zhukov.rpi_practice7

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukov.rpi_practice7.databinding.ActivityMainBinding

class MainActivityViewModel:ViewModel() {
    var msg: MutableLiveData<String> = MutableLiveData<String>()

    fun setValue(binding: ActivityMainBinding) {
        msg.value = """
            EditText: ${binding.editText?.text}
            CheckBox: ${if (binding.checkbox?.isChecked == true) {"ON"} else {"OFF"} }
            ToggleButton: ${if (binding.toggleButton?.isChecked == true) {"ON"} 
        else {"OFF"}}
            RadioGroup: ${
            when {
                binding.radioButton?.isChecked == true -> {"RadioButton 1"}
                binding.radioButton2?.isChecked == true -> {"RadioButton 2"}
                else -> {"Nothing"}
            }
        }
        """.trimIndent()
    }
}