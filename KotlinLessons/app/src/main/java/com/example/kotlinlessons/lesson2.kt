package com.example.kotlinlessons

fun main() {
    println("Lesson 2: Variables, Lists, and Loops")

    val hobbies = listOf("Coding", "Traveling", "Photography", "Reading")

    val skills = mutableListOf("Kotlin", "Java")
    skills.add("Android Development")

    println("My Hobbies:")
    for (hobby in hobbies) {
        println("- $hobby")
    }

    println("\nMy Skills:")
    skills.forEachIndexed { index, skill ->
        println("${index + 1}. $skill")
    }

    if ("Kotlin" in skills) {
        println("\nI am learning Kotlin!")
    }
}
