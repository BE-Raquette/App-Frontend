package fr.isen.racketselectorapp.model

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import fr.isen.racketselectorapp.R
import fr.isen.racketselectorapp.api.ApiRoutes
import fr.isen.racketselectorapp.data.UserData
import fr.isen.racketselectorapp.databinding.ActivityRecapBinding
import org.json.JSONObject

class RecapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecapBinding
    private lateinit var userData: UserData

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userData = intent.getSerializableExtra(CountdownActivity.USER_DATA) as UserData

        endSessionRequest()

        binding.helloUser.text = "${getString(R.string.hello)} ${userData.getName()} !"
    }

    private fun endSessionRequest() {
        val queue = Volley.newRequestQueue(this)
        val url = ApiRoutes.endSession(userData.getSessionId())
        val parameters = JSONObject()

        val request = JsonObjectRequest(
            Request.Method.PUT,
            url,
            parameters,
            {
                Log.d("put request", it.toString(2))
            }, {
                Log.d("put request", it.toString())
            })
        queue.add(request)
    }
}