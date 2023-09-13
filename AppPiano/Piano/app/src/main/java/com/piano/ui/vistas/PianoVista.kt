
package com.piano.ui.vistas


import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.piano.ui.clases.*
import com.piano.ui.vistas.*

class PianoVista(
    private val keyboard: Pianop = CreadorPiano().crearPianoPrincipal(),
    val liveDataKeys: MutableLiveData<Pianop> = MutableLiveData()
) : ViewModel() {

    init {
        liveDataKeys.postValue(keyboard)
    }

    fun updatePulsedKeys(keys: Array<Tecla>) {
        val keysToRelease = keyboard.teclas.filter { it.pulsada && !keys.contains(it) }
        val keysToPulse = keyboard.teclas.filter { !it.pulsada && keys.contains(it) }

        for (key in keysToRelease) keyboard.teclas.firstOrNull { it == key }?.pulsada = false
        for (key in keysToPulse) keyboard.teclas.firstOrNull { it == key }?.pulsada = true

        liveDataKeys.postValue(keyboard)
    }

    fun releaseKey(tecla: Tecla) {
        keyboard.teclas.firstOrNull { it == tecla }?.pulsada = false
        liveDataKeys.postValue(keyboard)
    }


    companion object {
        fun create(fragment: Fragment) = ViewModelProviders.of(fragment).get(PianoVista::class.java)
    }
}