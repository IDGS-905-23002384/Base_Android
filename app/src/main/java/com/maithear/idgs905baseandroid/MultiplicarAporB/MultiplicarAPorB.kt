package com.maithear.idgs905baseandroid.MultiplicarAporB

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maithear.idgs905baseandroid.R

class MultiplicarAPorB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multiplicar_apor_b)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNumeroA = findViewById<EditText>(R.id.etNumeroA)
        val etNumeroB = findViewById<EditText>(R.id.etNumeroB)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            val numAStr = etNumeroA.text.toString()
            val numBStr = etNumeroB.text.toString()

            if (numAStr.isNotEmpty() && numBStr.isNotEmpty()) {
                val intent = Intent(this, ResultadoMultiplicacion::class.java)
                intent.putExtra("NUMERO_A", numAStr.toInt())
                intent.putExtra("NUMERO_B", numBStr.toInt())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor llena ambos campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
