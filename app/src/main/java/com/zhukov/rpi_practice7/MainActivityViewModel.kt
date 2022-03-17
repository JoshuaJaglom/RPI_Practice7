package com.zhukov.rpi_practice7

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukov.rpi_practice7.databinding.ActivityMainBinding

class MainActivityViewModel:ViewModel() {
    var msg: MutableLiveData<String> = MutableLiveData()

    fun setValue(
        editTextValue: String,
        checkBoxValue: String,
        toggleButtonValue: String,
        radioButtonValue: String
    ) {
        msg.value = """
            EditText: $editTextValue
            CheckBox: $checkBoxValue
            ToggleButton: $toggleButtonValue
            RadioGroup: $radioButtonValue
        """.trimIndent()
    }
}