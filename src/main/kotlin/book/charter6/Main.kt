package book.charter6

import book.chapter5.Foo
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.lang.RuntimeException

fun main() {
    val foo: Foo? = null
    val bar: String = foo?.bar ?: "DEFAULT"
//    foo!!.bar

//    println(JavaPerson("test", 10).name.toUpperCase())
//    println(JavaPerson(null, 10).name?.toUpperCase())

    val longList = listOf(1L, 2L, 3L)
    val int = 1
//    println(int in longList)

    unitLambda1 { 10 }
    unitLambda2 { 10 }
    unitLambda3 { println(it) }

    var person: Person? = Person("test", 10)
    person.createOrUpdate("test1", 11)
    println("${person?.name} : ${person?.age}")
    person = null
    person = person.createOrUpdate("test2", 12)
    println("${person?.name} : ${person?.age}")

    println(collection(listOf(1,2,3), mutableListOf(4,5,6)))

    val letters = Array(26) { ('a' + it).toString() }
    println(letters.joinToString(" "))

    val squares = IntArray(5) { (it + 1) * (it + 1) }
    println(squares.joinToString(" "))

    arrayOf("A","B","C").forEachIndexed { index, element -> println("${index}: ${element}")}

    listOf(1,2,3) // readonly
    setOf(1,2,3) // readonly
    mutableListOf(1,2,3)
    arrayListOf(1,2,3)
    hashSetOf(1,2,3)
}

class Person(var name: String, var age: Int)

fun Person?.createOrUpdate(name:String, age: Int) =
    this?.let {
        it.name = name
        it.age = age
        return it
    } ?: Person(name, age)

fun unitLambda1(func: () -> Int) {}
fun unitLambda2(func: (Unit) -> Int) {}
fun unitLambda3(func: (Int) -> Unit) {}

fun nothing(type: String): Nothing {
    if(type == "1") {
        throw IllegalArgumentException()
    } else if (type =="2") {
        throw IllegalStateException()
    } else {
        throw RuntimeException()
    }
}

fun fail() {
    throw IllegalStateException(Thread.currentThread().name)
}

fun <T> printHashCode(t: T) =
    t?.hashCode()

fun <T: Any> printHashCode(t: T) =
    t.hashCode()

interface SomeInterface<T> {
    fun returnSomething(): T
}
class SomeConcrete1: SomeInterface<Int> {
    override fun returnSomething(): Int {
        TODO("Not yet implemented") // 값 반환
    }
}

class SomeConcrete2: SomeInterface<Unit> {
    override fun returnSomething() {
        TODO("Not yet implemented") // 값 반환 X
    }
}

class SomeConcrete3: SomeInterface<Nothing> {
    override fun returnSomething(): Nothing {
        TODO("Not yet implemented") // exception
    }
}

// MutableCollection implements Collection
fun collection(readCollection: Collection<Int>, writeCollection: MutableCollection<Int>): MutableCollection<Int> {
    readCollection.forEach { writeCollection.add(it) }
    return writeCollection
}