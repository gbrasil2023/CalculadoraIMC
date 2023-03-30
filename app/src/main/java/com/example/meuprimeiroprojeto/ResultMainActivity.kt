package com.example.meuprimeiroprojeto

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_main)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()



        val classificacao = if(result < 18.5f){
            "MAGREZA"
        }else if(result in 18.5f..24.9f){
            "PESO IDEAL"
        }else if(result in 25f..29.9f){
            "LEVEMENTE ACIMA DO PESO"
        }else if(result in 30f..34.9f){
            "OBESIDADE GRAU I"
        }else if(result in 35f..39.9f){
            "OBESIDADE SEVERA"
        }else{
            "OBESIDADE MÓRBIDA"
        }

        tvClassificacao.text = getString(R.string.massage_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}