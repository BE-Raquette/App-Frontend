package fr.isen.racketselectorapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import fr.isen.racketselectorapp.databinding.ActivityFormBinding
import org.json.JSONObject

class FormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding
    private var userData = UserData()
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        validationClick()

    }

    private fun validationClick() {
        binding.validateDataButton.setOnClickListener {
            if (checkInfo()) {
                saveUserData()
                val intent = Intent(this, ProcessActivity::class.java)
                intent.putExtra(USER_DATA, userData)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, R.string.form_incomplete, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkInfo(): Boolean {
        return (binding.maleButton.isChecked || binding.femaleButton.isChecked || binding.otherButton.isChecked) &&
            binding.enterNameInput.text?.isNotEmpty() == true &&
            binding.enterAgeInput.text?.isNotEmpty() == true &&
            binding.enterHeightInput.text?.isNotEmpty() == true &&
            binding.enterWeightInput.text?.isNotEmpty() == true
    }

    private fun saveUserData() {
        val name: String = binding.enterNameInput.text.toString()
        val age: Int = binding.enterAgeInput.text.toString().toInt()
        val gender: String = when (binding.genderList.checkedRadioButtonId) {
            binding.maleButton.id -> "male"
            binding.femaleButton.id -> "female"
            binding.otherButton.id -> "other"
            else -> ""
        }
        val height: Int = binding.enterHeightInput.text.toString().toInt()
        val weight: Int = binding.enterWeightInput.text.toString().toInt()

        userData.setName(name)
        userData.setAge(age)
        userData.setGender(gender)
        userData.setHeight(height)
        userData.setWeight(weight)

        postUserDataRequest()
    }

    private fun postUserDataRequest() {
        val queue = Volley.newRequestQueue(this)
        val url = ApiRoutes.BASE_URL + ApiRoutes.POST_USER

        val parameters = JSONObject()
        parameters.put(KEY_AGE, userData.getAge())
        parameters.put(KEY_GENDER, userData.getGender())
        parameters.put(KEY_HEIGHT, userData.getHeight())
        parameters.put(KEY_WEIGHT, userData.getWeight())

        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            parameters,
            {
                Log.d("post request", it.toString(2))
                userData.setSessionId(it.getString("session_id")) // doesn't work for the moment
            },
            {
                Log.d("post request", it.toString())
            }
        )
        queue.add(request)
    }

    companion object {
        const val USER_DATA = "USER_DATA"

        const val KEY_AGE = "age"
        const val KEY_GENDER = "gender"
        const val KEY_HEIGHT = "height"
        const val KEY_WEIGHT = "weight"
    }
}