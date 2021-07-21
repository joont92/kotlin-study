package realgame

import java.lang.IllegalArgumentException

class Lottery private constructor(private val type: Type, _numbers: ExtendedList<Int>) {
    val numbers: ExtendedList<Int> = _numbers
        get() = field.copy()

    init {
        println("${type.value} : ${this}")
    }

    fun equalsCount(lottery: Lottery): Int {
        return numbers.intersectSize(lottery.numbers)
    }

    override fun toString() = numbers.toEnumeratedString()

    companion object {
        val LOTTERY_COUNT: Int = 6
        val LOTTERY_MIN_NUMBER: Int = 1
        val LOTTERY_MAX_NUMBER: Int = 45

        fun auto(generator: (Int, Int) -> (Int)): Lottery {
            val numbers: ArrayList<Int> = arrayListOf()
            for (i in 1..LOTTERY_COUNT) {
                var randomNumber = generator(LOTTERY_MIN_NUMBER, LOTTERY_MAX_NUMBER)
                while (numbers.contains(randomNumber)) {
                    randomNumber = generator(LOTTERY_MIN_NUMBER, LOTTERY_MAX_NUMBER)
                }
                numbers.add(randomNumber)
            }

            return Lottery(Type.AUTO, ExtendedList(numbers))
        }

        fun manual(vararg numberArgs: Int): Lottery {
            val numberArgsSize = numberArgs.distinct().size
            if (numberArgsSize != LOTTERY_COUNT)
                throw IllegalArgumentException("Need to pick numbers at least ${numberArgsSize}")

            return Lottery(Type.MANUAL, ExtendedList(numberArgs.toList()))
        }
    }

    enum class Type(val value: String) {
        AUTO("자동"), MANUAL("수동")
    }
}
