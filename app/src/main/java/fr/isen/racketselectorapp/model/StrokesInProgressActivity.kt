package fr.isen.racketselectorapp.model

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.racketselectorapp.data.SessionData
import fr.isen.racketselectorapp.data.UserData
import fr.isen.racketselectorapp.databinding.ActivityStrokesInProgressBinding

class StrokesInProgressActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStrokesInProgressBinding
    private lateinit var userData: UserData
    private lateinit var sessionData: SessionData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStrokesInProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userData = intent.getSerializableExtra(CountdownActivity.USER_DATA) as UserData
        sessionData = intent.getSerializableExtra(CountdownActivity.SESSION_DATA) as SessionData

        setProgressText()
        finishButtonClick()
    }

    private fun setProgressText() {
        val strokeType: String = when(sessionData.getStrokeType()) {
            "forehand_strokes" -> "coups droits"
            "backhand-strokes" -> "revers"
            "serves" -> "services"
            "smashs" -> "smashs"
            "volleys" -> "volées"
            else -> "frappes"
        }

        binding.inProgressText.text = "Session de $strokeType en cours…"
    }

    private fun finishButtonClick() {
        binding.finishButton.setOnClickListener {
            goToRecapActivity()
        }
    }

    private fun goToRecapActivity() {
        val intent = Intent(this, RecapActivity::class.java)
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