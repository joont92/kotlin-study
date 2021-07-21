package lottery

fun <T> Collection<T>.toEnumeratedString() = this.join(",", "[", "]")

fun <T> Collection<T>.join(
    separator: String,
    prefix: String,
    postfix: String
): String {
    val sb = StringBuilder()

    sb.append(prefix)
    for ((index, element) in this.withIndex()) {
        sb.append(element)
        if (index < this.size - 1) {
            sb.append(separator)
        }
    }
    sb.append(postfix)

    return sb.toString()
}

data class ExtendedList<T> (
    val innerList: List<T>
): List<T> by innerList {
    fun intersectSize(list: List<T>) = innerList.intersect(list).size
}