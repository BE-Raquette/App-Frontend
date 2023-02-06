package fr.isen.racketselectorapp.model.process

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.isen.racketselectorapp.databinding.FragmentSmashBinding

class SmashFragment : Fragment() {
    private lateinit var binding: FragmentSmashBinding
    private lateinit var interactor: ProcessActivityInteraction

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interactor = context as ProcessActivityInteraction
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSmashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextSmashButton.setOnClickListener {
            interactor.showNextStep(BackhandFragment())
        }
    }
}