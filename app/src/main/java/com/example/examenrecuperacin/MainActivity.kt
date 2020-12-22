package com.example.examenrecuperacin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val duplicar = findViewById<Button>(R.id.button)
        val anadirnumero = findViewById<Button>(R.id.button2)
        val siguiente = findViewById<Button>(R.id.button3)
        val texto = findViewById<TextView>(R.id.textView)


        anadirnumero.setOnClickListener{
            val numero = Random.nextInt((1000 - 1)) + 1
            texto.text = "$numero"
        }

        texto.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {

                s?.let {
                    duplicar.isEnabled = it.isNotEmpty()
                    siguiente.isEnabled = it.isNotEmpty()

                }
            }
        })

        duplicar.setOnClickListener{
            val textonumero = texto.text
            val textonumero2 = textonumero.reversed()
            texto.text = "$textonumero$textonumero2"
        }

        siguiente.setOnClickListener{
            val text = texto.text
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(SecondActivity.PARAM1, text.toString())
            startActivity(intent)
        }

    }


    fun Random( length: Int ){

        val sb = StringBuilder(length)

        val alphabet = "9999"

        val rand = Random
        for ( i in 0 until sb.capacity() ) {

            val index = rand.nextInt( alphabet.length )
            sb.append( alphabet[ index ] )
        }

    }
}