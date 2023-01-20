package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalc: Button = findViewById(R.id.btnCalc) //Botão
        val edtHeight: EditText = findViewById(R.id.edtHeight) //Input de altura
        val edtWeight: EditText = findViewById(R.id.edtWeight) //Input de peso

        btnCalc.setOnClickListener() {
            val height = edtHeight.text.toString() // Recebendo o valor da altura
            val weight = edtWeight.text.toString() // Recebendo o valor do peso

            if (height != "" && weight != "") {
                if (height == "." || weight == ".") {
                    Toast.makeText(this, "Insira uma medida válida", Toast.LENGTH_LONG).show()
                } else {
                    val result = (weight.toDouble()) / (Math.pow(height.toDouble(), 2.0)) // IMC
//                    val resultStr = String.format("%.1f", result.toString())

                    val intent = Intent(this, ResultActivity::class.java)  //Atribuindo a ação à variável
                            .apply {
                                putExtra("EXTRA_RESULT",result)  //Enviando a informação à outra view
                            }
                    startActivity(intent) // Executando a ação
                }
            } else {
                    Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
                }

            }
        }
    }