package fr.isen.racketselectorapp

import java.io.Serializable

class UserData : Serializable {
    private var name: String = ""
    private var age: Int = 0
    private var gender: String = ""
    private var height: Int = 0
    private var weight: Int = 0

    private var sessionId: String = ""

    fun getName(): String {
        return this.name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getAge(): Int {
        return this.age
    }

    fun setAge(age: Int) {
        this.age = age
    }

    fun getGender(): String {
        return this.gender
    }

    fun setGender(gender: String) {
        this.gender = gender
    }

    fun getHeight(): Int {
        return this.height
    }

    fun setHeight(height: Int) {
        this.height = height
    }

    fun getWeight(): Int {
        return this.weight
    }

    fun setWeight(weight: Int) {
        this.weight = weight
    }

    fun getSessionId(): String {
        return this.sessionId
    }

    fun setSessionId(sessionId: String) {
        this.sessionId = sessionId
    }
}