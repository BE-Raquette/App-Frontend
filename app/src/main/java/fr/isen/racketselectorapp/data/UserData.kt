package fr.isen.racketselectorapp.data

import java.io.Serializable

class UserData : Serializable {
    private var name: String = ""
    private var age: Int = 0
    private var gender: String = ""
    private var height: Int = 0
    private var weight: Int = 0
    private var hand: String = ""

    fun getName(): String =
        this.name


    fun setName(name: String) {
        this.name = name
    }

    fun getAge(): Int =
        this.age


    fun setAge(age: Int) {
        this.age = age
    }

    fun getGender(): String =
        this.gender


    fun setGender(gender: String) {
        this.gender = gender
    }

    fun getHeight(): Int =
        this.height


    fun setHeight(height: Int) {
        this.height = height
    }

    fun getWeight(): Int =
        this.weight


    fun setWeight(weight: Int) {
        this.weight = weight
    }

    fun getHand(): String =
        this.hand


    fun setHand(hand: String) {
        this.hand = hand
    }
}