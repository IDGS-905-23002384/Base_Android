package com.maithear.idgs905baseandroid.CalcularDistancia

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maithear.idgs905baseandroid.R
import java.util.Locale

class CalcularDistancia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calcular_distancia)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtX1 = findViewById<EditText>(R.id.edtX1)
        val edtY1 = findViewById<EditText>(R.id.edtY1)
        val edtX2 = findViewById<EditText>(R.id.edtX2)
        val edtY2 = findViewById<EditText>(R.id.edtY2)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultadoDistancia)

        btnCalcular.setOnClickListener {
            val x1Str = edtX1.text.toString()
            val y1Str = edtY1.text.toString()
            val x2Str = edtX2.text.toString()
            val y2Str = edtY2.text.toString()

            if (x1Str.isNotEmpty() && y1Str.isNotEmpty() && x2Str.isNotEmpty() && y2Str.isNotEmpty()) {

                val x1 = x1Str.toDouble()
                val y1 = y1Str.toDouble()
                val x2 = x2Str.toDouble()
                val y2 = y2Str.toDouble()

                val restaX = x2 - x1
                val restaY = y2 - y1

                val potenciaX = Math.pow(restaX, 2.0)
                val potenciaY = Math.pow(restaY, 2.0)

                val distancia = Math.sqrt(potenciaX + potenciaY)

                txtResultado.text = String.format(Locale.US, "Resultado: %.2f", distancia)

            } else {
                txtResultado.text = "Por favor, llena todos los campos"
            }
        }
    }
}