package fr.isen.racketselectorapp.model.process

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.isen.racketselectorapp.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding
    private lateinit var interactor: ProcessActivityInteraction

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interactor = context as ProcessActivityInteraction
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.beginStartButton.setOnClickListener {
            interactor.showNextStep(ServeFragment())
        }
    }
}