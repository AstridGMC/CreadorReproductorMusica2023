package com.piano

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.Clases.Pianop
import com.vistas.PianoVista

class PianoFragmento : Fragment(){

        private lateinit var pianoLayout: PianoLayout

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
        ): View? {
                pianoLayout = PianoLayout(context)

            return pianoLayout
        }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)
            subscribeToVM(PianoVista.create(this))
        }

        private fun subscribeToVM(viewModel: PianoVista) {
            val keyboardObserver = Observer<Pianop> { piano ->
                if (piano != null) {
                    addKeyboardToLayout(piano)
                }
            }
            viewModel.liveDataKeys.observe(this, keyboardObserver)
        }

        private fun addKeyboardToLayout(keyboard: Pianop) {
            pianoLayout.clearKeyViews()
            pianoLayout.addKeyboard(keyboard)
        }


}