package fr.isen.racketselectorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.racketselectorapp.databinding.ActivityMainBinding
import fr.isen.racketselectorapp.databinding.SplashScreenBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}