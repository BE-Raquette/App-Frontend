package fr.isen.racketselectorapp.data

import android.util.JsonWriter
import org.json.JSONObject
import java.io.Serializable

class SessionData: Serializable {
    private var sessionId: String = ""
    private var strokeType: String = ""

    fun getSessionId(): String {
        return this.sessionId
    }

    fun setSessionId(sessionId: String) {
        this.sessionId = sessionId
    }

    fun getStrokeType(): String {
        return this.strokeType
    }

    fun setStrokeType(strokeType: String) {
        this.strokeType = strokeType
    }
}