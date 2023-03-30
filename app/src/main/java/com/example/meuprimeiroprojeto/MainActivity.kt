package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




            val btncalcular: Button = findViewById(R.id.btncalcular)
            val edtPeso: EditText = findViewById(R.id.edtTextPeso)
            val edtAltura: EditText = findViewById(R.id.edtTextAltura)


            btncalcular.setOnClickListener(){

                /*val message: String = edtPeso.text.toString()*/
                val alturaStr = edtAltura.text.toString()
                val pesoStr = edtPeso.text.toString()

                if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                    val altura: Float = alturaStr.toFloat()
                    val peso: Float = pesoStr.toFloat()

                    val alturaFinal: Float = altura * altura
                    val result: Float = (peso / alturaFinal)

                    println("SEU IMC É: " + result)


                    val intent = Intent(this, ResultMainActivity::class.java)
                        .apply {
                            putExtra("EXTRA_RESULT", result)
                        }
                    startActivity(intent)
                }else{
                  Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
                }
            }

    }
}