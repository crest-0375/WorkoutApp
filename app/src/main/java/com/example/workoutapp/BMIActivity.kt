package com.example.workoutapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.workoutapp.databinding.ActivityBmiBinding

class BMIActivity : AppCompatActivity() {
    private var binding: ActivityBmiBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_WorkoutApp)
        setContentView(binding?.root)

        setSupportActionBar(binding?.bmiActivityToolbar)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "BMI Calculator"
        }
        binding?.bmiActivityToolbar?.setNavigationOnClickListener {
            onBackPressed()
        }
        binding?.rgUnits?.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding?.rbMetricUnit?.id -> {
                    binding?.llBmiResult?.visibility = View.GONE
                    binding?.llUsUnit?.visibility = View.GONE
                    binding?.tilMetricUnitHeight?.visibility = View.VISIBLE
                }

                else -> {
                    binding?.llBmiResult?.visibility = View.GONE
                    binding?.llUsUnit?.visibility = View.VISIBLE
                    binding?.tilMetricUnitHeight?.visibility = View.GONE
                }
            }
        }
        binding?.btnCalculate?.setOnClickListener {
            val height = binding?.etMetricUnitHeight?.text
            val weight = binding?.etMetricUnitWeight?.text
            val metric = (weight?.isNotBlank() == true && height?.isNotBlank() == true)

            val heightUsFeet = binding?.etUsUnitFeet?.text
            val heightTvUsInch = binding?.etUsUnitInch?.text
            val us =
                (weight?.isNotBlank() == true && heightUsFeet?.isNotBlank() == true && heightTvUsInch?.isNotBlank() == true)
            if ((binding?.rgUnits?.checkedRadioButtonId == binding?.rbMetricUnit?.id && metric)
                || (binding?.rgUnits?.checkedRadioButtonId == binding?.rbUsUnit?.id && us)
            ) {
                val double = validateMaticUnits()
                val bmi = double.first / (double.second * double.second)
                displayBMIResult(bmi)
            } else Toast.makeText(this, "Please enter valid values.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun displayBMIResult(bmi: Float) {
        var bmiLabel: String
        var bmiDescription: String

        if (bmi.compareTo(15f) <= 0) {
            bmiLabel = "Very severely underweight"
            bmiDescription = "Oops! you really need to make better care of your self, Eat more!"
        } else if (bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0) {
            bmiLabel = "Severely underweight"
            bmiDescription = "Oops! you really need to make better care of your self, Eat more!"
        } else if (bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0) {
            bmiLabel = "Underweight"
            bmiDescription = "Oops! you need to better care of yourself, Eat more! "
        } else if (bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0) {
            bmiLabel = "Normal"
            bmiDescription = "Congratulations! you are in good shape!"
        } else if (bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0) {
            bmiLabel = "Overweight"
            bmiDescription = "Oops! you really need to take care iof yourself, Workout more!"
        } else if (bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0) {
            bmiLabel = "Obese class | Moderately obese"
            bmiDescription = "Oops! you really need to take care of yourself, Workout more!"
        } else if (bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0) {
            bmiLabel = "Obese class || Severely obese"
            bmiDescription = "OMG! very dangerous condition, Act now!"
        } else {
            bmiLabel = "Obese class ||| Very severely obese"
            bmiDescription = "OMG! very dangerous condition, Act now!"
        }
        binding?.llBmiResult?.visibility = View.VISIBLE
        binding?.tvYourBmi?.text = "Your BMI : ${String.format("%.2f", bmi)}"
        binding?.tvBmiText?.text = bmiLabel
        binding?.tvBmiDescription?.text = bmiDescription

    }

    private fun validateMaticUnits(): Pair<Float, Float> {

        val weight = binding?.etMetricUnitWeight?.text.toString().toFloat()

        return if (binding?.rgUnits?.checkedRadioButtonId == binding?.rbMetricUnit?.id) {
            val heightMetric = binding?.etMetricUnitHeight?.text.toString().toFloat() / 100
            Log.d("TAG", "$weight , $heightMetric")
            Pair(weight, heightMetric)
        } else {
            val heightUs = ((binding?.etUsUnitFeet?.text.toString().toFloat() * 12f) +
                    (binding?.etUsUnitInch?.text.toString().toFloat())) * 0.0254f
            Log.d("TAG", "$weight , $heightUs")
            Pair(weight, heightUs)
        }
    }
}