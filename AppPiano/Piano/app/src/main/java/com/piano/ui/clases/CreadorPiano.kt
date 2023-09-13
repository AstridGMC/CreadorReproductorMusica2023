package com.piano.ui.clases

class CreadorPiano{
    fun crearPianoPrincipal():Pianop{
        val listaTeclas = mutableListOf<Tecla>()
        val j=1
        for (i in 0..11) {
            listaTeclas.add(Tecla(i,false,j))
        }
        return Pianop(listaTeclas.toTypedArray())
    }
}