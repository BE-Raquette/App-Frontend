package fr.isen.racketselectorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.isen.racketselectorapp.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {
    lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        validationClick()
    }

    private fun validationClick() {
        binding.validateDataButton.setOnClickListener {
            if (checkInfo()) {
                val intent = Intent(this, ProcessActivity::class.java)
                intent.putExtra(USER_DATA, saveUserData())
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, R.string.form_incomplete, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkInfo(): Boolean {
        return binding.enterNameInput.toString().isNotEmpty() &&
                binding.enterAgeInput.toString().isNotEmpty() &&
                (binding.maleButton.isChecked || binding.femaleButton.isChecked || binding.otherButton.isChecked) &&
                binding.enterSizeInput.toString().isNotEmpty()
    }

    private fun saveUserData(): UserData {
        val name: String = binding.enterNameInput.text.toString()
        val age: Int = binding.enterAgeInput.text.toString().toInt()
        val genre: String = when (binding.radioGroup.checkedRadioButtonId) {
            binding.maleButton.id -> "male"
            binding.femaleButton.id -> "female"
            binding.otherButton.id -> "other"
            else -> ""
        }
        val size: Int = binding.enterSizeInput.text.toString().toInt()

        val userData = UserData()

        userData.setName(name)
        userData.setAge(age)
        userData.setGenre(genre)
        userData.setSize(size)

        return userData
    }

    companion object {
        const val USER_DATA = "USER_DATA"
    }
}