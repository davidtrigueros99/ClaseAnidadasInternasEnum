package com.example.claseanidadasinternasenum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var etn_Valor1:EditText? = null
    lateinit var etn_Valor2:EditText
    lateinit var tv_resultado:TextView
    lateinit var rbSuma:RadioButton
    lateinit var rbRestar:RadioButton
    lateinit var rbMultiplicar:RadioButton
    lateinit var rbDividir:RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Enum class o clases enumeradas
        //claseEnumeradas()
        //seguridadNula()
        //funciones()
        //clases()
        //clases anidadas (nested) y las clases internas (Inner)
        //claseAnidadaeInterna()

        etn_Valor1 = findViewById(R.id.etn_Valor1)
        etn_Valor2 = findViewById(R.id.etn_Valor2)
        tv_resultado = findViewById(R.id.tv_Resultado)
        rbSuma = findViewById(R.id.rb_Suma)
        rbRestar = findViewById(R.id.rb_Resta)
        rbMultiplicar = findViewById(R.id.rb_Multiplicar)
        rbDividir = findViewById(R.id.rb_Division)
    }

    enum class Direccion (val dir:Int){
        NORTE(1),SUR(-1),ESTE(1),OESTE(-1);

        fun descripcion():String{
            return when(this){
                NORTE -> "La direccion es Norte"
                SUR -> "La direccion es Sur"
                ESTE -> "La direccion es Este"
                OESTE -> "La direccion es Oeste"
            }
        }
    }
    private fun claseEnumeradas(){
        var direccionUsuario:Direccion?=null
        println(direccionUsuario)
        println("Direccion actual: $direccionUsuario")

        direccionUsuario = Direccion.NORTE
        println("Direccion actual: $direccionUsuario")
        direccionUsuario = Direccion.OESTE
        println("Direccion actual: $direccionUsuario")

        //propiedades por def
        println("Propiedad name: ${direccionUsuario.name}")
        println("Propiedad ordinal: ${direccionUsuario.ordinal}")
    }

    //Veremos seguridad contra nulos(null safety)
    fun seguridadNula(){
        var miString = "Programacion IV (20/09/2022)"
        //miString = null esto daria un error de compilacion
        println(miString)

        var miSeguridadNula:String? = "valor de seguridad nula"
        miSeguridadNula = null
        println(miSeguridadNula)

        //miSeguridadNula = "Le volvemos a cambiar el valor"
        //println(miSeguridadNula)

        /*if (miSeguridadNula != null){
          println(miSeguridadNula!!.toString())
        }else{
            println(miSeguridadNula!!.toString())
        }*/

        //llamadas seguras (safe call)
        println(miSeguridadNula?.length)
        miSeguridadNula?.let {
            println(it.toString())
        }?: kotlin.run {
            println(miSeguridadNula.toString())
        }
    }

    fun funciones(){
        decirHola()
        decirHola()
        decirHola()

        decirNombre("Kevin")
        decirNombre("Mario")
        decirNombre("Paola")

        val resultadoSuma = sumarDosNumeros(4, 6)
        println(resultadoSuma)

        println(sumarDosNumeros(9, 8))

        println(sumarDosNumeros(3, sumarDosNumeros(7, 5)))

        decirNombreEdad("Valeria", 21)
    }
    //Funcion simple
    fun decirHola(){
        println("Hola estudiantes")
    }
    //Funciones con un parametro de entrada
    fun decirNombre(nombre:String){
        println("Hola, tu nombre es ${nombre}")
    }
    fun decirNombreEdad(nombre:String, edad:Int){
        println("Hola, tu nombre es ${nombre} y mi edad es ${edad}")
    }
    //Funciones con un valor de retorno
    fun sumarDosNumeros(n1:Int, n2:Int):Int{
        var suma = n1 + n2
        return suma
    }

    fun clases(){
        val persona1 = Estudiantes("Victor", 22, arrayOf(Estudiantes.progra.PHP, Estudiantes.progra.JAVA))
        println(persona1.nombre)
        persona1.edad = 24
        println(persona1.edad)
        persona1.codigo()

        val persona2 = Estudiantes("Mariel", 20, arrayOf(Estudiantes.progra.PYTHON), arrayOf(persona1))
        persona2.edad = 24
        println(persona2.edad)
        persona2.codigo()
        println("${persona2.amigo?.first()?.nombre} es amigo de ${persona2.nombre}")
    }

    private fun claseAnidadaeInterna(){
        val miClaseAnidad = MiClaseAnidadaInterna.miClaseAnidada()
        val sumar = miClaseAnidad.suma(10, 5)
        println("El resultado de la suma es: $sumar")

        val miClaseInterna = MiClaseAnidadaInterna().miClaseInterna()
        val sumarDos = miClaseInterna.sumarUno(10)
        println("El resultado de sumar uno es $sumarDos")
        val sumarTres = miClaseInterna.sumarDos(5)
        println("El resultado de sumar uno es $sumarTres")
    }

    fun calcular(Vista:View){
        val valor1_String = etn_Valor1?.text.toString()
        val valor2_String = etn_Valor2.text.toString()

        val valor1_Int = valor1_String.toInt()
        val valor2_Int = Integer.parseInt(valor2_String)

        if(rbSuma.isChecked == true){
            val suma = valor1_Int + valor2_Int
            val resultado = suma.toString()
            tv_resultado.setText(resultado)
        }else if (rbRestar.isChecked == true){
            val resta = valor1_Int - valor2_Int
            val resultado = resta.toString()
            tv_resultado.setText(resultado)
        }else if(rbMultiplicar.isChecked == true){
            val multiplicar = valor1_Int * valor2_Int
            val resultado = multiplicar.toString()
            tv_resultado.setText(resultado)
        }else if (rbDividir.isChecked == true){
            val valor1_Dou = valor1_Int.toDouble()
            val valor2_Dou = valor2_Int.toDouble()

            if(valor1_Dou != 0.0 && valor2_Dou != 0.0){
                val division = valor1_Dou / valor2_Dou
                val resultado = division.toString()
                tv_resultado.setText(resultado)
            }else{
                Toast.makeText(this, "No podes dividir entre 0", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun btnSiguiente(vista:View){
        val ventana: Intent = Intent(applicationContext, ListViewApp::class.java)
        startActivity(ventana)
    }
}