package lottery

object LotteryMachine {
    val statisticsCreator = ::LotteryStatistics // == () -> LotteryStatistics

    fun createLotteries(money: Money, vararg manualNumbers: IntArray = emptyArray()): List<Lottery> {
        val list: ArrayList<Lottery> = arrayListOf()

        val count = (money divide 1000) - manualNumbers.size

        for (numbers in manualNumbers) {
            list.add(Lottery.manual(*numbers))
        }
        for (i in 1..count) {
            list.add(Lottery.auto { min, max -> (min..max).random() } )
        }

        return list
    }

    fun createWinningLottery(lotteries: List<Lottery>): Lottery {
        val winningLottery = Lottery.manual(
            *lotteries.maxFrequencyNumbers(Lottery.LOTTERY_COUNT).toIntArray())
        println("당첨번호 : ${winningLottery}")

        return winningLottery
    }

    fun createBonusLotteryNumber(lotteries: List<Lottery>) =
        lotteries.flatMap { it.numbers }
            .groupBy { it }
            .mapValues { it.value.size }
            .toList()
            .sortedByDescending { it.second }
            .map { it.first }
            .first()
}

fun List<Lottery>.maxFrequencyNumbers(size: Int): List<Int> =
    this.flatMap(Lottery::numbers) // 1,2,3,4,5,1,2,3
        .groupingBy { it } // 1 = {1,1,1} , 2 = {2,2}
        .eachCount() // 1 = 3, 2 =3, 3= 4..
        .toList() // (Pair(1,3), Pair(2,3), Pair(3,4)...)
        .sortedByDescending { it.second } // Pair(3,4), Pair(1,3), Pair(2,3)...
        .map { it.first } // 3,1,2....
        .map { it.number }
        .take(size) // 6개만!

fun Collection<Lottery>.checkResult(winningLottery: Lottery): LotteryStatistics {
    val statistics = LotteryMachine.statisticsCreator()

    this.map { it.equalsCount(winningLottery) } // [Lottery, Lottery, Lottery] -> [3, 2, 1, 4, 0 ...]
        .forEach { statistics.addResult(it) }

    return statistics
}