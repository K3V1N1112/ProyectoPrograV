package com.example.proyectoprograv.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.proyectoprograv.ExploreActivity
import com.example.proyectoprograv.InicioActivity
import com.example.proyectoprograv.R
import com.example.proyectoprograv.databinding.FragmentHomeBinding
import com.example.proyectoprograv.ui.gallery.GalleryFragment
import com.example.proyectoprograv.ui.gallery.GalleryViewModel
import com.example.proyectoprograv.ui.place.PlaceFragment
import com.example.proyectoprograv.ui.place.PlaceViewModel
import com.example.proyectoprograv.ui.settings.SettingsFragment

class HomeFragment : Fragment() {

private var _binding: FragmentHomeBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root: View = binding.root

//    val textView: TextView = binding.textHome
//    homeViewModel.text.observe(viewLifecycleOwner) {
//      textView.text = it
//    }

      val btnPlace: ImageButton = binding.imgButton0
      btnPlace.setOnClickListener{
          val transaction = activity?.supportFragmentManager?.beginTransaction()
          if (transaction != null) {
              transaction.replace(R.id.nav_host_fragment_content_explore, PlaceFragment())
          }
          if (transaction != null) {
              transaction.disallowAddToBackStack()
          }
          if (transaction != null) {
              transaction.commit()
          }
      }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}