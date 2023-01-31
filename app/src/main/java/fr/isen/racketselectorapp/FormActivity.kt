package fr.isen.racketselectorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.racketselectorapp.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {
    lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        validationClick()
    }

    fun validationClick() {
        binding.validateDataButton.setOnClickListener {
            val intent = Intent(this, ProcessActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}