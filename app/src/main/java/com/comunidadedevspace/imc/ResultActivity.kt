package com.comunidadedevspace.imc

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

        val resultShow = intent.getFloatExtra(KEY_RESULT_IMC, 0f )
        val tvResult = findViewById<TextView>(R.id.tv_result)
        tvResult.text = resultShow.toString()

        val tvCassification = findViewById<TextView>(R.id.tv_classification)
        val classification: String = if (resultShow <= 18.5f){
            "MAGREZA"
        } else if (resultShow > 18.5f && resultShow <= 24.9f){
            "NORMAL"
        } else if (resultShow > 25f && resultShow <= 29.9f){
            "SOBREPESO"
        } else if (resultShow > 30f && resultShow <= 30.9f) {
            "OBSESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        tvCassification.text = classification.toString()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}