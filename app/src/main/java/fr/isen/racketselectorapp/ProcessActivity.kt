package fr.isen.racketselectorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import fr.isen.racketselectorapp.databinding.ActivityProcessBinding
import fr.isen.racketselectorapp.process.StartFragment

interface ProcessActivityInteraction {
    fun showNextStep(fragment: Fragment)
}

class ProcessActivity : AppCompatActivity(), ProcessActivityInteraction {
    lateinit var binding: ActivityProcessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProcessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = StartFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit()
    }

    override fun showNextStep(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}