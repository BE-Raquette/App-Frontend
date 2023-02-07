package fr.isen.racketselectorapp.model.process

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.isen.racketselectorapp.databinding.FragmentBackhandBinding

class BackhandFragment : Fragment() {
    private lateinit var binding: FragmentBackhandBinding
    private lateinit var interactor: ProcessActivityInteraction

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interactor = context as ProcessActivityInteraction
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBackhandBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.finishBackhandButton.setOnClickListener {
            interactor.goToRecapActivity()
        }
    }
}