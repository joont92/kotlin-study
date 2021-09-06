package book.chapter9

fun main() {
//    var testClassParent1: TestClass<Parent> = TestClass()
//    var testClassParent2: TestClass<*> = TestClass()
//    var testClassChild: TestClass<Child> = TestClass()
//    testClassParent1 = testClassChild
//    testClassParent2 = testClassChild

    multipleGeneric(TestGenericImpl())

    printSum(listOf("1","2","3"))
}

open class Parent
class Child: Parent()
class TestClass<T>

fun <T: Comparable<T>> max(a: T, b: T) =
    if(a > b) a else b

fun <T> multipleGeneric(param: T) where T: TestInterface1, T: TestInterface2, T: TestInterface3 {}

interface TestInterface1
interface TestInterface2
open class TestInterface3

class TestGenericImpl: TestInterface1, TestInterface2, TestInterface3()

class TypeErasureExample {
    fun test(list: List<Int>) {}
//    fun test(list: List<String>) {} // compile error
}

fun printSum(c: Collection<*>) {
    val intList = c as? List<Int>
    println(intList?.sum())
}

fun <A: Any> isA(value: A) {
    value.hashCode()
    val list = listOf<A>()
    val clazz2 = value::class.java
}
inline fun <reified B: Any> isB(value: B) {
    val clazz = B::class.java
    val clazz2 = value::class.java
}

fun <T> notInlineWithGeneric() {
//    inlineWithGeneric<T>() // exception
}

inline fun <reified T> inlineWithGeneric() {

}