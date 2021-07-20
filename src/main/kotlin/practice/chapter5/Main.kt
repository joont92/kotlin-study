package practice.chapter5

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
    val p = createPerson("joont", 30)
    val p2 = createPerson2("joont", 30)
    println(p.name)
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
}

fun lambda(): () -> Int {
    var num = 10
    return { num++ }
}

fun lambdaTest2(a: Int, b: Int): (Int, Int) -> String {
    return { c, d -> "${c} + ${d}" }
}

fun test(param: (Int) -> Int) {
    println(param(10))
}

class Person(val name: String, val age: Int)