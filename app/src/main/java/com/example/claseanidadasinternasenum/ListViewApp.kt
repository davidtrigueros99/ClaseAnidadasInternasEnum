package com.example.claseanidadasinternasenum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get

class ListViewApp : AppCompatActivity() {
    private var lvLenguajes:ListView? = null
    private var tvSeleccion:TextView? = null

    private val lenguajes = arrayOf("Kotlin", "Java", "C#", "C++", "PHP", "VB.Net")
    private val posiciones = arrayOf("1", "2", "3", "4", "5", "6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_app)

        lvLenguajes = findViewById(R.id.lv_Lenguajes)
        tvSeleccion = findViewById(R.id.tv_Seleccion)

        val adaptador:ArrayAdapter<String> = ArrayAdapter<String>(this, R.layout.list_item_claseprogramacion, lenguajes)
        lvLenguajes?.adapter = adaptador

        lvLenguajes?.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tvSeleccion?.text = "La posicion del lenguaje ${lvLenguajes?.getItemAtPosition(position)} es ${posiciones[position]}"
            }

        }
    }
}