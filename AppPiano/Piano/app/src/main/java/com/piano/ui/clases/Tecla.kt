package com.piano.ui.clases

class Tecla(val nota:Int, var pulsada:Boolean=false, val octava:Int){
    fun isBlanca(): Boolean = nota in arrayOf(0,2,3,4,5,6,11);

}