package realgame

import java.util.*
import kotlin.collections.ArrayList

class Lottery {
    private val LOTTERY_COUNT: Int = 6
    private val LOTTERY_MAX_NUMBER: Int = 45
    private val numbers: ArrayList<Int> = arrayListOf()

    fun init(): Lottery {
        for (i in 1..LOTTERY_COUNT) {
            var randomNumber = Random().nextInt(LOTTERY_MAX_NUMBER) + 1
            while (numbers.contains(randomNumber)) {
               randomNumber = Random().nextInt(LOTTERY_MAX_NUMBER) + 1
            }
            numbers.add(randomNumber)
        }

        return this
    }

    fun equalsCount(lottery: Lottery): Int {
        val copied: ArrayList<Int> = ArrayList(numbers)
        copied.removeAll(lottery.numbers)
        return copied.size
    }

    override fun toString() = numbers.toEnumeratedString()
}