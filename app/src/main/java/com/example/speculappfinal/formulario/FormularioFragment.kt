package com.example.speculappfinal.formulario

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.speculappfinal.MainActivity
import com.example.speculappfinal.R
import com.example.speculappfinal.databinding.FragmentFormularioBinding


class FormularioFragment : Fragment(R.layout.fragment_formulario) {
    private var _binding: FragmentFormularioBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val formularioViewModel =
            ViewModelProvider(this).get(FormularioViewModel::class.java)

        _binding = FragmentFormularioBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //Aquí se programa
        val buttonVolver = binding.buttonVolverFormulario
        buttonVolver.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}