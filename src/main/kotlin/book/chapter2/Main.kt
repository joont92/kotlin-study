import java.io.BufferedReader
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.util.*

//import test.min
//
//fun max(a: Int, b: Int) = if(a > b) a else b
//
//class Test {
//    fun fakeMax(a: Int, b: Int) = min(a,b)
//}

fun main() {
//    println(max(1,2))
//    println(min(1,2))
//    println(Test().fakeMax(1,2))

    val message: String
    if (Math.random() < 0.5) {
        message = "test"
    } else {
        message = "non test"
    }

    println("message is ${message}")
    println("message is ${if(message.contains("non")) "good!" else "bad"}")

    println(Person("joont").name)
//    Person("joont").name = "test"

    println(Rectangle(1,1).isSquare)
    println(getMnemonic(Color.BLUE))
    println(mix(Color.BLUE, Color.GREEN))

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))

//    for (i in 1..100) {
//        println(fizzBus(i))
//    }

//    for (i in 100 downTo 1 step 2) {
//        println(fizzBus(i))
//    }
//
//    for (i in 1 until 100 step 2) {
//        println(fizzBus(i))
//    }

    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        binaryReps[c] = Integer.toBinaryString(c.toInt())
    }
    for ((letter, binary) in binaryReps) {
        println("${letter} : ${binary}")
    }

    val list = listOf(1,2,3,4,5)
    for ((index, element) in list.withIndex()) {
        println("list[${index}] = ${element}")
    }

    println(isLetter('F'))
    println(isNotDigit('A'))

    test(100)

    println(readNumber(BufferedReader(StringReader("aaa"))))
}

class Person(val name: String)

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean =
//        println("height: ${height} width: ${width}")
        height == width
//    }
//    val isSquare: Boolean
//        get() {
//            println("height: ${height} width: ${width}")
//            return height == width
//        }
}

enum class Color(val r: Int,val g: Int,val b: Int) {
    RED(255,0,0), ORANGE(255, 165, 0), BLUE(0,111,222), GREEN(111,232,44);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color) =
    when(color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.BLUE, Color.GREEN -> "BLUEGREEN!"
    }

fun mix(c1: Color, c2: Color) =
    when(listOf(c1, c2)) {
        listOf(Color.RED, Color.ORANGE) -> Color.BLUE
        listOf(Color.BLUE, Color.GREEN) -> Color.BLUE
        else -> throw IllegalArgumentException()
    }

fun mix2(c1: Color, c2: Color) =
    when {
        c1 == Color.RED && c2 == Color.ORANGE -> Color.RED
        else -> throw IllegalArgumentException()
    }

interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value
        is Sum -> eval(expr.left) + eval(expr.right)
        else -> throw IllegalArgumentException("unknown expr")
    }

fun fizzBus(i: Int) =
    when {
        i % 15 == 0 -> "FizzBuz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buz"
        else -> "${i}"
    }

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun test(number: Int) {
    val percentage =
        if(number in 1..100) number
        else throw IllegalArgumentException()
    println(percentage + 10)
}

fun readNumber(reader: BufferedReader) =
    try {
        reader.readLine().toInt()
    } catch (e: NumberFormatException) {
        null
    } finally {
        reader.close()
    }

fun test21(a: Int) =
    if(a == 10) {
        println(10)
        a
    } else {
        println(20)
        10
    }