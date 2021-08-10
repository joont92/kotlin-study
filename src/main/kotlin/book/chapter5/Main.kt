package book.chapter5

fun main() {
    val sum = { x: Int, y: Int -> x + y}
    println(sum(1,2))

    val list = listOf(1,2,3,4,5)
    list.maxByOrNull { it }

    list.joinToString("") { i: Int -> i.toString() }

    val lambda = lambda()
    println(lambda())
    println(lambda())
    println(lambda())
    println(lambda())

    val person = Person("Z", 0)
    val nameLambda = Person::name
    println(nameLambda(person))
    val people = listOf(Person("A",1), Person("B",2), Person("C",3), Person("D", 2), Person("E", 3))
    println(people.joinToString(transform = nameLambda))

    val createPerson = ::Person
    val createPerson2 = { name: String, age: Int -> Person(name, age) }
    val p1 = createPerson("joont", 30)
    val p2 = createPerson2("joont", 30)
    println(p1.name)
    println(p2.name)

    test { number -> number }

    val element = list.find { it % 2 == 0 }
    println(element!!)

    val ageMap = people.groupBy { it.age }
    println(ageMap)

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })

    val stringLists = listOf(listOf("abc", "def"), listOf("ghi", "jkl"))
    println(stringLists.flatten())

    personLambda1(Person::age)
    personLambda2(::Person)
    val p = Person("joont", 10)
    personLambda3(p::age)

    val listAsSequence = listOf("A", "B", "C", "D", "E")

    listAsSequence.asSequence()
        .filter { println("filtered"); it.toCharArray()[0].code % 2 == 0 }
        .map { println("mapped"); it.plus("added") }
        .toList() // filter + map -> filter + map -> filter + map ...

    val naturalNumbers = generateSequence(0) { it + 1 }
        val numbersTo100 = naturalNumbers.filter { it % 2 == 0 }.takeWhile { it <= 100 }
    println(numbersTo100.sum())

    println(alphabet())
    println(alphabet2())
    println(alphabet3())
    println(alphabet4())

    println(receiverLambdaTest(10) { toString() })
    println(10.receiverLambdaTest2 { toString() })
}

class Foo(val bar: String) {
    override fun equals(other: Any?): Boolean {
        if (other is Foo && other == this) {
            return true
        }
        return true
    }
}
fun sendMail(foo: Foo) {
    println("sent")
}

fun lambda(): () -> Int {
    var num = 10
    return { num++ }
}

fun test(param: (Int) -> Int) {
    println(param(10))
}

class Person(val name: String, val age: Int)

fun personLambda1(exp: (Person) -> Int) { }

fun personLambda2(exp: (String, Int) -> Person) { }

fun personLambda3(exp: () -> Int) { }

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun alphabet2(): String {
    return with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")

        toString()
    }
}

fun alphabet3(): String {
    return StringBuilder().apply {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
    }.toString()
}

fun alphabet4(): String {
    return buildString {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet!")
    }
}

fun receiverLambdaTest(number: Int, block: Int.() -> String): String = number.block()
fun Int.receiverLambdaTest2(block: Int.() -> String): String = block()
