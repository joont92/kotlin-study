package realgame

import java.util.*
import kotlin.collections.ArrayList

object LotteryMachine {
    fun createLotteries(money: Money, vararg manualNumbers: IntArray = emptyArray()): List<Lottery> {
        val list: ArrayList<Lottery> = arrayListOf()

        val count = (money divide 1000) - manualNumbers.size

        for (numbers in manualNumbers) {
            list.add(Lottery.manual(*numbers))
        }
        for (i in 1..count) {
            list.add(Lottery.auto(RandomNumberGenerator(Lottery.LOTTERY_MAX_NUMBER)))
        }

        return list
    }

    fun createWinningLottery(): Lottery {
        val winningLottery = Lottery.auto(
            object : NumberGenerator {
                override fun generateNumber() =
                    (0..Lottery.LOTTERY_MAX_NUMBER).random()
            }
        )
        println("당첨번호 : ${winningLottery}")

        return winningLottery
    }
}

fun Collection<Lottery>.checkResult(winningLottery: Lottery): LotteryStatistics {
    val statistics = LotteryStatistics()

    for (lottery in this) {
        statistics.addResult(lottery.equalsCount(winningLottery))
    }
    return statistics
}