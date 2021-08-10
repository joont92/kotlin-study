package lottery

import java.lang.IllegalArgumentException

class LotteryNumber private constructor(val number: Int) {
    init {
        if (number !in LOTTERY_MIN_NUMBER..LOTTERY_MAX_NUMBER) {
            throw IllegalArgumentException(
                "LotteryNumber must be between ${LOTTERY_MIN_NUMBER} and ${LOTTERY_MAX_NUMBER}")
        }
    }

    companion object {
        const val LOTTERY_MIN_NUMBER: Int = 1
        const val LOTTERY_MAX_NUMBER: Int = 45

        fun from(number: Int) = LotteryNumber(number)
    }

    override fun equals(other: Any?): Boolean {
        val lotteryNumber = other as? LotteryNumber ?: return false
        return number == lotteryNumber.number
    }

    override fun hashCode(): Int {
        return number
    }
}