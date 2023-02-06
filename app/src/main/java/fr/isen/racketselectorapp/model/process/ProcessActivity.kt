package fr.isen.racketselectorapp.model.process

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import fr.isen.racketselectorapp.model.FormActivity
import fr.isen.racketselectorapp.R
import fr.isen.racketselectorapp.model.RecapActivity
import fr.isen.racketselectorapp.data.UserData
import fr.isen.racketselectorapp.databinding.ActivityProcessBinding

interface ProcessActivityInteraction {
    fun showNextStep(fragment: Fragment)
    fun goToRecapActivity()
}

class ProcessActivity : AppCompatActivity(), ProcessActivityInteraction {
    private lateinit var binding: ActivityProcessBinding
    private lateinit var userData: UserData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProcessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userData = intent.getSerializableExtra(FormActivity.USER_DATA) as UserData

        val fragment = StartFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit()
    }

    override fun showNextStep(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    override fun goToRecapActivity() {
        val intent = Intent(this, RecapActivity::class.java)
        intent.putExtra(USER_DATA, userData)
        startActivity(intent)
        finish()
    }

    companion object {
        const val USER_DATA = "USER_DATA"
    }
}