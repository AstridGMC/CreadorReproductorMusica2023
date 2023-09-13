import android.content.res.Resources
import androidx.core.content.res.ResourcesCompat
import com.piano.R
import com.vistas.TeclaVista

class ManejadorFondos(private val resources: Resources?) {
   private fun getDrawable(id: Int) =
       if (resources != null) ResourcesCompat.getDrawable(resources, id, null) else null

   fun setViewBackground(keyView: TeclaVista) {
       keyView.background = when {
           keyView.tecla.isBlanca() && keyView.tecla.pulsada -> getDrawable(R.drawable.tecla_blanca_pulsada_fondo)
           keyView.tecla.isBlanca() -> getDrawable(R.drawable.tecla_blanca_pulsada_fondo)
           keyView.tecla.pulsada -> getDrawable(R.drawable.tecla_negra_pulsada_fondo)
           else -> getDrawable(R.drawable.tecla_negra_pulsada_fondo)
       }
   }
}