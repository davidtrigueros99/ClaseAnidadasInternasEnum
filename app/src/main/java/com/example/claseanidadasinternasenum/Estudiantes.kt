package com.example.claseanidadasinternasenum

class Estudiantes(var nombre:String, var edad:Int, var lenguaje:Array<progra>, val amigo:Array<Estudiantes>?=null) {
    enum class progra{
        KOTLIN,
        PHP,
        JAVA,
        PYTHON,
        JAVASCRIPT
    }

    fun codigo(){
        for (lenguaje:progra in lenguaje){
            println("Se programar en $lenguaje")
        }
    }
}