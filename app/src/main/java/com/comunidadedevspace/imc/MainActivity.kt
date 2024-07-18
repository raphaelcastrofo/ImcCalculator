package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)

        val btnCalculate = findViewById<Button>(R.id.btn_Calculate)

        btnCalculate.setOnClickListener {

            val weightStr: String = edtWeight.text.toString()
            val heightStr: String = edtHeight.text.toString()

            if (weightStr == "" || heightStr == "") {
                //show mensage to the user
                Snackbar
                    .make(
                        edtWeight,
                        "fill in all the fields",
                        Snackbar.LENGTH_LONG
                    )
                    .show()


            } else {
                val weight: Float = weightStr.toFloat()
                val height: Float = heightStr.toFloat()

                //IMC calculus:
                val heightQ2 = height * height
                val result = weight / heightQ2

                println("The IMC is: " + result)
            }
        }
    }
}