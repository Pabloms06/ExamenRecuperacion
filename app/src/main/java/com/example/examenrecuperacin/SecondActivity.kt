package com.example.examenrecuperacin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly

class SecondActivity : AppCompatActivity() {

    companion object {
        const val PARAM1 = "datos"
    }

    //he conseguido pasar los datos pero no ejecutar el apartado f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)

        val texto = intent.getStringExtra(PARAM1)

        val textonumerico = findViewById<EditText>(R.id.editText)
        val boton = findViewById<Button>(R.id.button4)

        textonumerico.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {

                s?.let {
                    boton.isEnabled = it.isDigitsOnly()

                }
            }
        })

    }
}

        /*boton.setOnClickListener{
            texto?.let {
                texto.text = separar(it)
            }
        }



    }

    private fun separar(texto : String) : String {
        var output = texto
        texto.forEach {
            output = output.plus(it,",")
        }
        return output
    }
}*/