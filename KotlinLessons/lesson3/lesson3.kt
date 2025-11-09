fun greet(name: String): String {
    return "Hello, $name! Welcome to Kotlin Lesson 3."
}

fun square(num: Int): Int {
    return num * num
}

fun main() {
    println("Lesson 3: Functions Example")

    val name = "Kushwanth"
    val greeting = greet(name)
    println(greeting)

    val number = 7
    val result = square(number)
    println("The square of $number is $result")
}
