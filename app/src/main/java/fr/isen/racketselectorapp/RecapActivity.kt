package fr.isen.racketselectorapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.racketselectorapp.databinding.ActivityRecapBinding

class RecapActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecapBinding
    private lateinit var userData: UserData

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userData = intent.getSerializableExtra(ProcessActivity.USER_DATA) as UserData

        binding.helloUser.text = "${getString(R.string.hello)} ${userData.getName()} !"
    }
}