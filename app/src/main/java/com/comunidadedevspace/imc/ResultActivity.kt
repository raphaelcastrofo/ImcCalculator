package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#87F4B5")

        val resultShow = intent.getFloatExtra(KEY_RESULT_IMC, 0f )
        val tvResult = findViewById<TextView>(R.id.tv_result)
        tvResult.text = resultShow.toString()

        val tvClassification = findViewById<TextView>(R.id.tv_classification)
        val classification: String = if (resultShow <= 18.5f){
            tvClassification.setTextColor(Color.parseColor("#1f93f2"))
            "UNDERWEIGHT"
        } else if (resultShow > 18.5f && resultShow <= 24.9f) {
            tvClassification.setTextColor(Color.parseColor("#3af27d"))
            "NORMAL"
        } else if (resultShow > 25f && resultShow <= 29.9f) {
            tvClassification.setTextColor(Color.parseColor("#ff974c"))
            "OVERWEIGHT"
        } else {
            tvClassification.setTextColor(Color.parseColor("#f76871"))
            "OBESITY"
        }

        tvClassification.text = classification

        // Configure the new TextView for detailed description
        val tvDescription = findViewById<TextView>(R.id.tv_description)
        val description: String = when (classification) {
            "UNDERWEIGHT" -> """
    Your BMI indicates that you are underweight. Being underweight may lead to a weakened immune system, nutritional deficiencies, and other health issues. Consider incorporating a balanced diet with adequate calories and nutrients to gain weight healthily. Consulting a healthcare professional or nutritionist can provide personalized advice.
            """
            "NORMAL" -> """
        Your BMI falls within the normal range, which generally indicates a balanced weight relative to your height. Maintain a healthy lifestyle by continuing to eat a balanced diet and engage in regular physical activity.
            """

            "OVERWEIGHT" -> """
    Your BMI indicates that you are overweight. Being overweight can increase the risk of developing health conditions such as heart disease, diabetes, and hypertension. Making lifestyle changes can help you manage your weight more effectively.
            """

            "OBESITY" -> """
    Your BMI indicates obesity, which can significantly impact your overall health. Obesity is associated with a higher risk of chronic conditions like diabetes, cardiovascular diseases, and joint issues. It is crucial to take steps to manage your weight effectively.
            """
           else -> "Description not available."
        }
        tvDescription.text = description

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}