package fr.isen.racketselectorapp.model

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import fr.isen.racketselectorapp.R
import fr.isen.racketselectorapp.api.ApiRoutes
import fr.isen.racketselectorapp.data.SessionData
import fr.isen.racketselectorapp.data.UserData
import fr.isen.racketselectorapp.databinding.ActivityRecapBinding
import org.json.JSONObject

class RecapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecapBinding
    private lateinit var userData: UserData
    private lateinit var sessionData: SessionData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userData = intent.getSerializableExtra(CountdownActivity.USER_DATA) as UserData
        sessionData = intent.getSerializableExtra(CountdownActivity.SESSION_DATA) as SessionData

        binding.helloUser.text = getString(R.string.hello_user, userData.getName())

        postSessionDataRequest()
    }

    private fun postSessionDataRequest() {
        val queue = Volley.newRequestQueue(this)
        val url = ApiRoutes.postSessionData(sessionData.getSessionId(), sessionData.getStrokeType())
        val parameters = JSONObject()
        parameters.put("2023-02-28 16:13:56", "1")

        val request = JsonObjectRequest(
            Request.Method.POST,
            url,
            parameters,
            {
                Log.d("data request", it.toString(2))
            }, {
                Log.d("data request", it.toString())
            })
        queue.add(request)
    }
}