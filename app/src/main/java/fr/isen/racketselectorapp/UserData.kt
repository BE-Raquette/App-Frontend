package fr.isen.racketselectorapp

import java.io.Serializable

class UserData : Serializable {
    private var name: String = ""
    private var age: Int = 0
    private var genre: String = ""
    private var size: Int = 0

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

    fun getGenre(): String {
        return this.genre
    }

    fun setGenre(genre: String) {
        this.genre = genre
    }

    fun getSize(): Int {
        return this.size
    }

    fun setSize(size: Int) {
        this.size = size
    }
}