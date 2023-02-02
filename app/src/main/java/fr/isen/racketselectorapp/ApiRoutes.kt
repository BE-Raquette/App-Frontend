package fr.isen.racketselectorapp

class ApiRoutes {
    companion object {
        const val BASE_URL = "http://192.168.186.137:8080" // local address, usable with yo connection
        const val POST_USER = "/sessions/start"

        fun endSession(sessionId: String): String {
            return "$BASE_URL/$sessionId/end"
        }
    }
}