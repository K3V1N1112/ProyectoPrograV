package com.example.proyectoprograv.ui.info

import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.proyectoprograv.R
import com.example.proyectoprograv.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

private var _binding: FragmentInfoBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val infoViewModel =
            ViewModelProvider(this).get(InfoViewModel::class.java)

    _binding = FragmentInfoBinding.inflate(inflater, container, false)
    val root: View = binding.root

//    val textView: TextView = binding.textInfo
//    infoViewModel.text.observe(viewLifecycleOwner) {
//      textView.text = it
//    }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        val bd = activity?.openOrCreateDatabase("version", AppCompatActivity.MODE_PRIVATE, null)
        val numVer = bd?.rawQuery("select ver from version where _id like '1'", null)
        numVer?.moveToFirst()
        val version = numVer?.getString(0)
        binding.lblVersion.setText(version)
        numVer?.close()
    }

}