package com.example.helloworld

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import java.text.DecimalFormat


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult : TextView = findViewById(R.id.textView_result)
        val tvDescription : TextView = findViewById(R.id.textView_description)

        val result = intent.getDoubleExtra("EXTRA_RESULT", 0.0)

        val df = DecimalFormat("#.#")

        val resultF = df.format(result)

        tvResult.text = resultF

        val classification : String
        if (result < 18.5) {
            classification = "Abaixo do peso normal"
            tvDescription.setTextColor(getColor(R.color.gray))
        } else if (result in 18.5..24.9) {
            classification = "Peso normal"
            tvDescription.setTextColor(getColor(R.color.green))
        } else if (result in 25.0..29.9) {
            classification = "Sobrepeso"
            tvDescription.setTextColor(getColor(R.color.yellow))
        } else if (result in 30.0..34.9) {
            classification = "Obesidade I"
            tvDescription.setTextColor(getColor(R.color.orange))
        } else {
            classification = "Obesidade II"
            tvDescription.setTextColor(getColor(R.color.red))
        }
        tvDescription.text = classification.toString()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}