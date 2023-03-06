package fr.isen.racketselectorapp.model

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.isen.racketselectorapp.R
import fr.isen.racketselectorapp.data.SessionData
import fr.isen.racketselectorapp.data.UserData
import fr.isen.racketselectorapp.databinding.ActivityStrokeTypologyBinding

class StrokeTypologyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStrokeTypologyBinding
    private lateinit var userData: UserData
    private lateinit var sessionData: SessionData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStrokeTypologyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userData = intent.getSerializableExtra(FormActivity.USER_DATA) as UserData
        sessionData = intent.getSerializableExtra(FormActivity.SESSION_DATA) as SessionData

        startButtonClick()
    }

    private fun startButtonClick() =
        binding.startButton.setOnClickListener {
            if (checkIfShotIsSelected()) {
                sessionData.setStrokeType(convertStrokeTypeToString())
                goToCountdown()
            } else {
                Toast.makeText(this, R.string.stroke_selection_incomplete, Toast.LENGTH_LONG).show()
            }
        }


    private fun checkIfShotIsSelected(): Boolean =
        binding.forehandShot.isChecked || binding.backhandShot.isChecked || binding.serveShot.isChecked || binding.volleyShot.isChecked || binding.smashShot.isChecked


    private fun convertStrokeTypeToString(): String =
        when (binding.strokeTypeList.checkedRadioButtonId) {
            binding.forehandShot.id -> "forehand_strokes"
            binding.backhandShot.id -> "backhand_strokes"
            binding.smashShot.id -> "smashs"
            binding.serveShot.id -> "serves"
            binding.volleyShot.id -> "volleys"
            else -> ""
        }

    private fun goToCountdown() {
        val intent = Intent(this, CountdownActivity::class.java)
        intent.putExtra(USER_DATA, userData)
        intent.putExtra(SESSION_DATA, sessionData)
        startActivity(intent)
        finish()
    }

    companion object {
        const val USER_DATA = "USER_DATA"
        const val SESSION_DATA = "SESSION_DATA"
    }
}