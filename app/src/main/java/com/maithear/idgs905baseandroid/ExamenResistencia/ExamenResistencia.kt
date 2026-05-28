package com.maithear.idgs905baseandroid.ExamenResistencia

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maithear.idgs905baseandroid.R
import kotlin.math.pow

class ExamenResistencia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_examen_resistencia)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spBanda1 = findViewById<Spinner>(R.id.spBanda1)
        val spBanda2 = findViewById<Spinner>(R.id.spBanda2)
        val spBanda3 = findViewById<Spinner>(R.id.spBanda3)

        val tvValorBanda1 = findViewById<TextView>(R.id.tvValorBanda1)
        val tvValorBanda2 = findViewById<TextView>(R.id.tvValorBanda2)
        val tvValorBanda3 = findViewById<TextView>(R.id.tvValorBanda3)

        val rgTolerancia = findViewById<RadioGroup>(R.id.rgTolerancia)
        val vColorTolerancia = findViewById<View>(R.id.vColorTolerancia)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        val tvValorOhm = findViewById<TextView>(R.id.tvValorOhm)
        val tvValorMaximo = findViewById<TextView>(R.id.tvValorMaximo)
        val tvValorMinimo = findViewById<TextView>(R.id.tvValorMinimo)

        val colores = arrayOf(
            "Negro", "Cafe", "Rojo", "Naranja", "Amarillo",
            "Verde", "Azul", "Violeta", "Gris", "Blanco"
        )

        val coloresHex = arrayOf(
            "#000000", "#8B4513", "#FF0000", "#FFA500", "#FFFF00",
            "#008000", "#0000FF", "#EE82EE", "#808080", "#FFFFFF"
        )

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, colores)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spBanda1.adapter = adaptador
        spBanda2.adapter = adaptador
        spBanda3.adapter = adaptador

        fun actualizarEstiloTextView(textView: TextView, position: Int) {
            textView.setBackgroundColor(Color.parseColor(coloresHex[position]))
            if (position == 0 || position == 6) {
                textView.setTextColor(Color.WHITE)
            } else {
                textView.setTextColor(Color.BLACK)
            }
        }

        spBanda1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tvValorBanda1.text = position.toString()
                actualizarEstiloTextView(tvValorBanda1, position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spBanda2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tvValorBanda2.text = position.toString()
                actualizarEstiloTextView(tvValorBanda2, position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spBanda3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val multiplicador = 10.0.pow(position.toDouble()).toInt()
                tvValorBanda3.text = multiplicador.toString()
                actualizarEstiloTextView(tvValorBanda3, position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        rgTolerancia.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.rbOro) {
                vColorTolerancia.setBackgroundColor(Color.parseColor("#FFD700"))
            } else {
                vColorTolerancia.setBackgroundColor(Color.parseColor("#C0C0C0"))
            }
        }

        btnCalcular.setOnClickListener {
            val b1 = spBanda1.selectedItemPosition
            val b2 = spBanda2.selectedItemPosition
            val b3 = spBanda3.selectedItemPosition

            val digitos = "$b1$b2".toInt()
            val multiplicador = 10.0.pow(b3.toDouble()).toLong()
            val valorBaseOhm = digitos * multiplicador

            val porcentajeTolerancia = if (rgTolerancia.checkedRadioButtonId == R.id.rbOro) 0.05 else 0.10

            val variacion = valorBaseOhm * porcentajeTolerancia
            val valorMaximo = valorBaseOhm + variacion
            val valorMinimo = valorBaseOhm - variacion

            tvValorOhm.text = valorBaseOhm.toString()
            tvValorMaximo.text = valorMaximo.toInt().toString()
            tvValorMinimo.text = valorMinimo.toInt().toString()
        }
    }
}