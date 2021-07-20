package practice.chapter4

fun main() {
    Button().showOff()
    TalkativeButton().giveSpeech()

    println(Num(10))
    Sum(Num(10), Num(20))

    println(Student("NOT TEST", 10).name)
    Student2("JOONT")
    Student2("JOONT", 10)

    val v1 = VO("joont", 30)
    val v2 = VO("joont", 30)
    v2.sex = 'F'
    println(v1 == v2)

    CompanionUser.newFacebookUser(1)

    Student3("joont:30")
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

class Student(_name: String, val age: Int) {
    var name: String

    init {
        name = _name
    }

    init {
        name = "TEST"
    }
}

class Student2 {
    // 생성자에서 무조건 초기화 해야함
    val name: String
    val age: Int

    constructor(_name: String, _age: Int) {
        name = _name
        age = _age
    }

    constructor(_name: String) {
        name = _name
        age = 10
    }

    init {
        println("test")
    }
}

class Student3 private constructor(val name: String, val age: Int) {
    constructor(fullString: String): this(
        fullString.substringBefore(":"),
        fullString.substringAfter(":").toInt())

    init {
        println("name: ${name}, age: ${age}")
    }
}

interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String): User

class SubscribingUser(val email: String): User {
    override val nickname: String
        get() = email.substringBefore("@")
}

class FacebookUser(val accountId: Int): User {
    override val nickname: String = accountId.toString()
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

data class VO(val name: String, val age: Int) {
    var sex: Char = 'M'
}

class DelegatingCollection<T>(
    private val innerList: Collection<T> = ArrayList()
): Collection<T> by innerList {
    fun concatSize(collection: Collection<T>) = innerList.size + collection.size
}

class CompanionUser private constructor(val nickname: String){

    companion object {
        val NICKNAME_PREFIX = "NICK_"

        fun newSubscribingUser(email: String) {
            CompanionUser(NICKNAME_PREFIX + email.substringBefore("@"))
        }

        fun newFacebookUser(facebookAccountId: Int) {
            CompanionUser(NICKNAME_PREFIX + facebookAccountId.toString())
        }
    }
}