package fr.isen.racketselectorapp.model

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import fr.isen.racketselectorapp.R
import fr.isen.racketselectorapp.api.ApiRoutes
import fr.isen.racketselectorapp.data.SessionData
import fr.isen.racketselectorapp.data.UserData
import fr.isen.racketselectorapp.databinding.ActivityFormBinding
import org.json.JSONObject

class FormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding
    private var userData = UserData()
    private var sessionData = SessionData()

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
                postUserDataRequest()
                //goToShotTypologyActivity() //to test without request
            } else {
                Toast.makeText(this, R.string.form_incomplete, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun checkInfo(): Boolean {
        return binding.enterNameInput.text?.isNotEmpty() == true &&
                binding.enterAgeInput.text?.isNotEmpty() == true &&
                (binding.maleButton.isChecked || binding.femaleButton.isChecked || binding.otherButton.isChecked) &&
                binding.enterHeightInput.text?.isNotEmpty() == true &&
                binding.enterWeightInput.text?.isNotEmpty() == true &&
                (binding.leftHandButton.isChecked || binding.rightHandButton.isChecked)
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
        val hand: String = when (binding.handPref.checkedRadioButtonId) {
            binding.leftHandButton.id -> "left"
            binding.rightHandButton.id -> "right"
            else -> ""
        }

        userData.setName(name)
        userData.setAge(age)
        userData.setGender(gender)
        userData.setHeight(height)
        userData.setWeight(weight)
        userData.setHand(hand)
    }

    private fun postUserDataRequest() {
        val queue = Volley.newRequestQueue(this)
        val url = ApiRoutes.POST_USER

        val parameters = JSONObject()
        parameters.put(KEY_AGE, userData.getAge())
        parameters.put(KEY_GENDER, userData.getGender())
        parameters.put(KEY_HEIGHT, userData.getHeight())
        parameters.put(KEY_WEIGHT, userData.getWeight())
        parameters.put(KEY_HAND, userData.getHand())

        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            parameters,
            {
                Log.d("post request", it.toString(2))
                userData.setSessionId(it.getString("session_id"))
                sessionData.setSessionId(it.getString("session_id"))
                goToShotTypologyActivity()
            },
            {
                Log.d("post request", it.toString())
            }
        )

        queue.add(request)
    }

    private fun goToShotTypologyActivity() {
        val intent = Intent(this, StrokeTypologyActivity::class.java)
        intent.putExtra(USER_DATA, userData)
        intent.putExtra(SESSION_DATA, sessionData)
        startActivity(intent)
        finish()
    }

    companion object {
        const val USER_DATA = "USER_DATA"
        const val SESSION_DATA = "SESSION_DATA"

        const val KEY_AGE = "age"
        const val KEY_GENDER = "gender"
        const val KEY_HEIGHT = "height"
        const val KEY_WEIGHT = "weight"
        const val KEY_HAND = "hand"
    }
}