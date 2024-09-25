package br.unipar.conversormoedas

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val valorInserido = findViewById<EditText>(R.id.edNumero)
        val taxaConversao = findViewById<EditText>(R.id.edNumero2)
        val botaoConverter = findViewById<Button>(R.id.btnConvert)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        botaoConverter.setOnClickListener {
            val numeroString = valorInserido.text.toString()
            val taxaString = taxaConversao.text.toString()


            if (numeroString.isNotEmpty() && taxaString.isNotEmpty()) {
                val numero = numeroString.toDouble()
                val taxa = taxaString.toDouble()
                val resultadoValor = numero * taxa
                resultado.text = "Resultado: $resultadoValor"

            } else {
                resultado.text = "Nenhum número foi inserido."
            }
        }
    }

    fun limparValores(view: View) {
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val input = findViewById<EditText>(R.id.edNumero)
        val input2 = findViewById<EditText>(R.id.edNumero2)

        resultado.setText("")
        input.setText("")
        input2.setText("")
    }
}