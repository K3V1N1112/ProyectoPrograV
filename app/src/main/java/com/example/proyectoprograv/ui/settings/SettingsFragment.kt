package com.example.proyectoprograv.ui.settings

import android.content.Context
import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.proyectoprograv.R
import com.example.proyectoprograv.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

private var _binding: FragmentSettingsBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val galleryViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)

    _binding = FragmentSettingsBinding.inflate(inflater, container, false)
    val root: View = binding.root

//    val textView: TextView = binding.textGallery
//    galleryViewModel.text.observe(viewLifecycleOwner) {
//      textView.text = it
//    }

      val btnVersion: Button = binding.btnVersion
      btnVersion.setOnClickListener{
          version()
      }

    return root

  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    public fun version() {
        val txtVersion: EditText = binding.txtVersion
        val prueba = txtVersion.text
        val bd = activity?.openOrCreateDatabase("version", AppCompatActivity.MODE_PRIVATE, null)
        bd?.execSQL("update version set ver = $prueba where _id like '1'")
        //bd?.execSQL("insert into version(ver) values('$txtVersion')")
        Toast.makeText(activity, "Version cambiada con éxito", Toast.LENGTH_LONG).show()
        binding.txtVersion.setText("")
    }

}