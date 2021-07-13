package practice.chapter3

import java.lang.StringBuilder

const val UNIX_LINE_SEPERATOR = "\n"

 /*
@JvmOverloads
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "(",
    postfix: String = ")"
): String {
    val result = StringBuilder(prefix)

    for((i, e) in collection.withIndex()) {
        if(i > 0) result.append(separator)
        result.append(e)
    }
    result.append(postfix)
    return result.toString()
}
 */

// java로 변환시 collection 객체가 첫번째 인자로 전달된 static 메서드가 생성되므로, 위의 joinToString과 충돌한다
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "(",
    postfix: String = ")"
): String {
    val result = StringBuilder(prefix)

    for((i, e) in this.withIndex()) {
        if(i > 0) result.append(separator)
        result.append(e)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "(",
    postfix: String = ")"
) = joinToString(separator, prefix, postfix)

fun String.lastChar(): Char = get(length - 1)

//fun String.trim() = this.length.toString()

val String.lastChar: Char
    get() = get(length - 1)