package fr.isen.racketselectorapp.model

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import fr.isen.racketselectorapp.R
import fr.isen.racketselectorapp.data.UserData
import fr.isen.racketselectorapp.databinding.ActivityShotTypologyBinding

class ShotTypologyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShotTypologyBinding
    private lateinit var userData: UserData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShotTypologyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userData = intent.getSerializableExtra(FormActivity.USER_DATA) as UserData

        startButtonClick()
    }

    private fun startButtonClick() {
        binding.startButton.setOnClickListener {
            if (checkIfShotIsSelected()) {
                goToCountdown()
            } else {
                Toast.makeText(this, R.string.radio_group_incomplete, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkIfShotIsSelected(): Boolean {
        return binding.forehandShot.isChecked ||
                    binding.backhandShot.isChecked ||
                    binding.serveShot.isChecked ||
                    binding.volleyShot.isChecked ||
                    binding.smashShot.isChecked
    }

    private fun goToCountdown() {
        val intent = Intent(this, CountdownActivity::class.java)
        intent.putExtra(USER_DATA, userData)
        startActivity(intent)
        finish()
    }

    companion object {
        const val USER_DATA = "USER_DATA"
    }
}