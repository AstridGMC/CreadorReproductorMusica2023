package com.piano.ui.vistas

import ManejadorFondos
import android.content.Context
import com.piano.ui.clases.Tecla

class CreadorVistasTeclas(
    private val context: Context?,
    private val backgroundManager: ManejadorFondos = ManejadorFondos(context?.resources)
) {

    fun createViews(keys: Array<Tecla>): Array<TeclaVista> {
        val views = mutableListOf<TeclaVista>()

        for (key in keys) {
            val view = TeclaVista(context, key)
            backgroundManager.setViewBackground(view)
            views.add(view)
        }

        return views.toTypedArray()
    }
}