package book.chapter3

open class View
class Button: View()

fun View.showOff() = println("I'm view")
fun Button.showOff() = println("I'm button")