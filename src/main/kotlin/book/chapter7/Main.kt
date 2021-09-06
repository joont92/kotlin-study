package book.chapter7

fun main() {
    var class1 = Class1()
    println(class1["0", "11"])
    println(class1["10", "10"])
    println(class1())
    println(class1++)
    println(class1 + "123")
}

class Class1 {
    operator fun get(index: String, index2: String) = 0

    operator fun invoke() = "invoked!"

    operator fun plus(other: String) = other + toString()

    operator fun inc(): Class1 {
        return this
    }
}