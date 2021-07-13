package practice.chapter3

fun main() {
    val set = setOf(1, 2, 3) // == LinkedHashSet(linkedSetOf)
    val list = listOf(1, 2, 3) // == Arrays.ArrayList(!= arrayListOf)
    val map = mapOf(1 to "one", 2 to "two", 3 to "three") // == LinkedHashMap(linkedMapOf)

//    println(joinToString(listOf("123","123","32323")))
//    println(joinToString(listOf("123","123","32323"), prefix = "{", postfix = "}"))
    println(listOf("123","123","32323").joinToString())
    println(listOf("123","123","32323").joinToString(prefix = "{", postfix = "}"))
    println(listOf("123","123","32323").join(separator = ";"))

    println(TestClass().callMyName())
    println(TestClass().callMyName(10))

    val view: View = Button()
    view.showOff()

    println(" Test ".trim())
    val test = "Test"
    println(test.lastChar)

    println(nameNamesName("A", "BC", "DE", name2 = "F"))

    println("12.345-6.A".split("."))
//    println("12.345-6.A".split(".", "-"))

    val (a, b, c) = Destructed("1", 2, 3.0)

    println("""
        test
            test
                test
    """.trimMargin("t"))
}

class TestClass {
    private val name = "JOONT"

    fun callMyName() = name
    private fun callYourName() = "hyewon"
}

data class Destructed(val a: String, val b: Int, val c: Double)

fun TestClass.callMyName(time: Int): String {
    val sb = StringBuilder()
    for(i in 1..time) {
        sb.append(callMyName())
    }

    return sb.toString()
}

fun nameNamesName(name1: String, vararg names: String, name2: String) =
    "${name1} ${names.size} ${name2}"

fun testFun(name: String, vararg names: String, age: Int)
        = "TEST"