package fr.isen.racketselectorapp.api

class ApiRoutes {
    companion object {
        private const val BASE_URL =
            "http://192.168.236.137:8080" // local address, usable with Yo connection

        const val POST_USER = "$BASE_URL/sessions/start"

        fun postSessionData(sessionId: String, strokeType: String): String =
            "$BASE_URL/data/$sessionId/$strokeType"
    }
}