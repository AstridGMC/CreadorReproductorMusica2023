package com.piano

import android.content.Context
import android.widget.LinearLayout
import com.Clases.Pianop
import com.vistas.CreadorVistasTeclas
import com.vistas.TeclaVista

class PianoLayout (
        context: Context?,
        private val TeclaVistas: MutableList<TeclaVista> = mutableListOf(),
        private val keyViewFactory: CreadorVistasTeclas = CreadorVistasTeclas(context)
    ) :
        LinearLayout(context) {

        private val relativeBlackWidth = 0.6 //relative width to white keys width
        private val relativeBlackHeight = 0.6 //relative height to white keys height
        private var keyWidth = 0

        fun clearKeyViews() {
            TeclaVistas.clear()
            this.removeAllViews()
        }

        fun addKeyboard(keyboard: Pianop) {
            val views = keyViewFactory.createViews(keyboard.teclas)

            TeclaVistas.addAll(views)
            for (view in views.filter { it.tecla.isBlanca() }) this.addView(view)
            for (view in views.filter { !it.tecla.isBlanca() }) this.addView(view)

            if (TeclaVistas.size > 0) sizeKeys()
        }

        override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
            super.onSizeChanged(w, h, oldw, oldh)
            if (TeclaVistas.size > 0) sizeKeys()
        }

        override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
            super.onLayout(changed, l, t, r, b)
            if (TeclaVistas.size > 0) sizeKeys()
        }

        private fun sizeKeys() {
            val whiteKeys = TeclaVistas.filter { it.tecla.isBlanca() }
            keyWidth = if (whiteKeys.isNotEmpty()) width / whiteKeys.size else 0
            var initPosition = 0

            for (view in TeclaVistas) {
                if (view.tecla.isBlanca()) {
                    sizeWhiteKey(view, initPosition)
                    initPosition++
                } else {
                    sizeBlackKey(view, initPosition)
                }
            }
        }

        private fun sizeBlackKey(view: TeclaVista, initPosition: Int) {
            val left = ((initPosition - relativeBlackWidth / 2) * keyWidth).toInt()
            val right = (left + keyWidth * relativeBlackWidth).toInt()
            val bottom = (height * relativeBlackHeight).toInt()
            view.layout(left, 0, right, bottom)
        }

        private fun sizeWhiteKey(view: TeclaVista, initPosition: Int) {
            var initPosition1 = initPosition
            val right = if (view == TeclaVistas.last()) width else (initPosition1 + 1) * keyWidth
            view.layout(initPosition1 * keyWidth, 0, right, height)
        }

    }
