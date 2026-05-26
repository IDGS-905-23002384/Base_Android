package com.maithear.idgs905baseandroid.Ejemplo2

import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maithear.idgs905baseandroid.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val tvResult=findViewById<TextView>(R.id.tvResult)
        val name: String= intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvResult.text="Hola $name"

        val spinner = findViewById< Spinner>(R.id.spColores)
        val colores = arrayOf(
            "Negro",
            "Cafe",
            "Rojo",
            "Naranja",
            "Amarillo"
        )

        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            colores
        )

        adaptador.setDropDownViewResource(
            android.R.layout.simple_spinner_item,
        )
        spinner.adapter = adaptador

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val seleccion = spinner.selectedItem.toString()
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: android.view.View?,
                position: Int,
                id: Long
            ) {
                val option = colores[position]
                Toast.makeText(this@ResultActivity, option, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}