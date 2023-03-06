package fr.isen.racketselectorapp.model

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import fr.isen.racketselectorapp.R
import fr.isen.racketselectorapp.data.SessionData
import fr.isen.racketselectorapp.data.UserData
import fr.isen.racketselectorapp.databinding.ActivityCountdownBinding

class CountdownActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCountdownBinding
    private lateinit var userData: UserData
    private lateinit var sessionData: SessionData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountdownBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userData = intent.getSerializableExtra(StrokeTypologyActivity.USER_DATA) as UserData
        sessionData =
            intent.getSerializableExtra(StrokeTypologyActivity.SESSION_DATA) as SessionData

        countdownToStart()
    }

    private fun countdownToStart() =
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.countdownText.text = "${millisUntilFinished / 1000 + 1}"
            }

            override fun onFinish() {
                binding.countdownText.text = getString(R.string.go)
                goToInProgressActivity()
            }
        }.start()

    private fun goToInProgressActivity() =
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, StrokesInProgressActivity::class.java)
            intent.putExtra(USER_DATA, userData)
            intent.putExtra(SESSION_DATA, sessionData)
            startActivity(intent)
            finish()
        }, 1000)

    companion object {
        const val USER_DATA = "USER_DATA"
        const val SESSION_DATA = "SESSION_DATA"
    }
}