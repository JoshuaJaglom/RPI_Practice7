package com.zhukov.rpi_practice2_8

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhukov.rpi_practice2_8.databinding.ActivityMainBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivityViewModel:ViewModel() {
    var solution: MutableLiveData<Int> = MutableLiveData<Int>()

    fun getSolution(binding: ActivityMainBinding, solutionName: String) {
        val sideA: Int = roundOffDecimal(binding.sideA.text.toString().toDouble())
        val sideB: Int = roundOffDecimal(binding.sideB.text.toString().toDouble())
        val sideC: Int = roundOffDecimal(binding.sideC.text.toString().toDouble())
        when (solutionName) {

            "Сумма длины ребер" -> {
                solution.value = sideA * 4 + sideB * 4 + sideC * 4
            }
            "Площадь поверхности" -> {
                solution.value = 2 * (sideA * sideB + sideB * sideC + sideA * sideC)
            }
            else -> {
                solution.value = sideA * sideB * sideC
            }
        }
    }

    private fun roundOffDecimal(number: Double): Int {
        val df = DecimalFormat("#")
        df.roundingMode = RoundingMode.HALF_UP
        return df.format(number).toInt()
    }
}