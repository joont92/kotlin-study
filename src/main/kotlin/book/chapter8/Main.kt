package book.chapter8

fun main() {

}

/* inline */ fun inlineFunction1(operator: (Int) -> Int) =
    InlineClass(operator, 1) // exception: 람다를 바로 사용해야만 인라이닝 가능

inline fun inlineFunction2(noinline operator: (Int) -> Int, function: (String) -> Int) =
    InlineClass(operator, function("1"))

class InlineClass(
    val operator: (Int) -> Int,
    val functionResult: Int
)
