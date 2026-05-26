package com.maithear.idgs905baseandroid.MultiplicarAporB

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maithear.idgs905baseandroid.R

class ResultadoMultiplicacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_multiplicacion)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvResultadoSuma = findViewById<TextView>(R.id.tvResultadoSuma)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        val numA = intent.getIntExtra("NUMERO_A", 0)
        val numB = intent.getIntExtra("NUMERO_B", 0)

        var resultadoTotal = 0
        val desarrolloSuma = StringBuilder()

        for (i in 1..numA) {
            resultadoTotal += numB
            desarrolloSuma.append(numB)
            if (i < numA) {
                desarrolloSuma.append(" + ")
            }
        }

        if (numA == 0 || numB == 0) {
            tvResultadoSuma.text = "Resultado: 0"
        } else {
            tvResultadoSuma.text = "Resultado: ${desarrolloSuma.toString()} = $resultadoTotal"
        }

        btnRegresar.setOnClickListener {
            val intent = Intent(this, MultiplicarAPorB::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}