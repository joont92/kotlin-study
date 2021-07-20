package realgame

object LotteryMachine {
    val statisticsCreator = ::LotteryStatistics // () -> LotteryStatistics

    fun createLotteries(money: Money, vararg manualNumbers: IntArray = emptyArray()): List<Lottery> {
        val list: List<Lottery> = listOf()

        val count = (money divide 1000) - manualNumbers.size

        for (numbers in manualNumbers) {
            list.plus(Lottery.manual(*numbers))
        }
        for (i in 1..count) {
            list.plus(Lottery.auto { min, max -> (min..max).random() } )
        }

        return list
    }

    fun createWinningLottery(lotteries: List<Lottery>): Lottery {
        val winningLottery = Lottery.manual(
            *lotteries.lowFrequencyNumbers(Lottery.LOTTERY_COUNT).toIntArray())
        println("당첨번호 : ${winningLottery}")

        return winningLottery
    }
}

fun List<Lottery>.lowFrequencyNumbers(size: Int) =
    this.flatMap(Lottery::numbers)
        .groupingBy { it }
        .eachCount()
        .toList()
        .sortedByDescending { it.second }
        .map { it.first }
        .take(size)

fun Collection<Lottery>.checkResult(winningLottery: Lottery): LotteryStatistics {
    val statistics = LotteryMachine.statisticsCreator()

    this.map { it.equalsCount(winningLottery) }
        .forEach { statistics.addResult(it) }

    return statistics
}