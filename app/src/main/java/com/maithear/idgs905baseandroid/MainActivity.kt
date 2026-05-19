package com.maithear.idgs905baseandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maithear.idgs905baseandroid.CalcularDistancia.CalcularDistancia
import com.maithear.idgs905baseandroid.Ejemplo1.ejemplo1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnEjemplo1=findViewById<Button>(R.id.btn1)
        val btnCalcularDistancia = findViewById<Button>(R.id.btn2)
        ViewCompat.setOnApplyWindowInsetsListener( findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnEjemplo1.setOnClickListener { navegateToEjemplo1() }
        btnCalcularDistancia.setOnClickListener { navigateToCalcularDistancia() }
    }
    fun navegateToEjemplo1(){
        val intent = Intent(this, ejemplo1::class.java)
        startActivity(intent)
    }

    fun navigateToCalcularDistancia(){
        val intent = Intent(this, CalcularDistancia::class.java)
        startActivity(intent)
    }
}