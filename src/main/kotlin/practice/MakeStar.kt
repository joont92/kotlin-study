package realgame

/**
 * 확장함수
 * loop
 * when
 * infix
 * custom get, set
 */
fun main() {
    println("question1"); asc()
    println("question2"); asc(true)
    println("question3"); asc(true)
    println("question2"); asc(true)
    println("question2"); asc(true)
    println("question2"); asc(true)
}

fun asc(flip: Boolean = false) =
    if (!flip) {
        for (i in 1..5) {
            println("*" multiply i)
        }
    } else {
        for (i in 1..5) {
            println("${" " multiply 5 - i}${"*" multiply i}")
        }
    }

fun desc() {
    for (i in 5 downTo 1) {
        println()
    }
}

infix fun String.multiply(count: Int): String {
    val sb = StringBuilder()
    for (i in 1..count) {
        sb.append(this)
    }
    return sb.toString()
}