package com.example.proyectoprograv.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.proyectoprograv.R
import com.example.proyectoprograv.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

private var _binding: FragmentGalleryBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

    _binding = FragmentGalleryBinding.inflate(inflater, container, false)
    val root: View = binding.root

//    val textView: TextView = binding.textGallery
//    galleryViewModel.text.observe(viewLifecycleOwner) {
//      textView.text = it
//    }

      val btnGuardar: Button = binding.btnGuardar
      btnGuardar.setOnClickListener{
          save()
      }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun save(){
        Toast.makeText(activity, "Datos Guardados", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        val bd = activity?.openOrCreateDatabase("usuarios", AppCompatActivity.MODE_PRIVATE, null)
        val user = bd?.rawQuery("select usuario, correo from usuarios where _id like '1'", null)
        user?.moveToFirst()
        val usuario = user?.getString(0)
        val correo = user?.getString(1)
        binding.txtUser.setText(usuario)
        binding.txtCorreo.setText(correo)
        user?.close()
    }

//    public fun actualizarDatos() {
//        val txtUser: EditText = binding.txtUser
//        val user = txtUser.text
//        val txtCorreo: EditText = binding.txtCorreo
//        val correo = txtCorreo.text
//        val txtPass: EditText = binding.txtPass
//        val pass = txtPass.text
//        val bd = activity?.openOrCreateDatabase("usuarios", AppCompatActivity.MODE_PRIVATE, null)
//        bd?.execSQL("update usuarios set usuario = $user, correo = $correo, contrasena = $pass where _id like '10'")
//        Toast.makeText(activity, "Datos Guardados", Toast.LENGTH_SHORT).show()
//        binding.txtPass.setText("")
//    }
}