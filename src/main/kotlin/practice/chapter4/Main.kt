package practice.chapter4

fun main() {
    Button().showOff()
    TalkativeButton().giveSpeech()

    println(Num(10))
    Sum(Num(10), Num(20))
}

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if(b) "got" else "lost"} focus")
    fun showOff() = println("I'm focusable")
}

class Button: Clickable, Focusable {
    override fun click() {
        TODO("Not yet implemented")
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

open class RichButton: Clickable {
    fun disable() {}
    open fun animate() {}
    override fun click() { // override 가능
        TODO("Not yet implemented")
    }
}

class RichButtonImpl: RichButton() {
    override fun click() {
        super.click()
    }

    override fun animate() {
        super.animate()
    }
}

internal open class TalkativeButton: Focusable {
    private fun yell() = println("Hey!!")
    protected fun whispher() = println("(Let's talk)")
}

internal fun TalkativeButton.giveSpeech() {

}

sealed class Expr
class Num(val value: Int): Expr()
class Sum(val left: Expr, val right: Expr): Expr()