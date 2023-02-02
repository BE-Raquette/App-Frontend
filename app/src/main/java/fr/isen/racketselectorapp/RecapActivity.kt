package fr.isen.racketselectorapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import fr.isen.racketselectorapp.databinding.ActivityRecapBinding
import org.json.JSONObject

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

    fun endSessionRequest() { // to be completed when sessionId is stored correctly
        val queue = Volley.newRequestQueue(this)
        val url = ApiRoutes.BASE_URL + ApiRoutes.endSession(userData.getSessionId())
        val parameters = JSONObject()

        val request = JsonObjectRequest(
            Request.Method.PUT,
            url,
            parameters,
            {
                Log.d("post request", it.toString(2))
            },
            {
                Log.d("post request", it.toString())
            }
        )
        queue.add(request)
    }
}