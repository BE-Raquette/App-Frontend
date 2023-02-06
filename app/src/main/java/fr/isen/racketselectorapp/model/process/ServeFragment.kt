package fr.isen.racketselectorapp.model.process

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.isen.racketselectorapp.databinding.FragmentServeBinding

class ServeFragment : Fragment() {
    private lateinit var binding: FragmentServeBinding
    private lateinit var interactor: ProcessActivityInteraction

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interactor = context as ProcessActivityInteraction
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextServeButton.setOnClickListener {
            interactor.showNextStep(ForehandFragment())
        }
    }
}