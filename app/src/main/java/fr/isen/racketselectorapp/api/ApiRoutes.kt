package fr.isen.racketselectorapp.api

class ApiRoutes {
    companion object {
        const val BASE_URL = "http://192.168.236.137:8080" // local address, usable with Yo connection

        const val POST_USER = "/sessions/start"

        fun endSession(sessionId: String): String {
            return "$BASE_URL/sessions/$sessionId/end"
        }
    }
}