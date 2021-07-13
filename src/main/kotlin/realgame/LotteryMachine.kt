package realgame

fun createLotteries(money: Money): List<Lottery> {
    val list: ArrayList<Lottery> = arrayListOf()

    val count = money divide 1000

    for (i in 1..count) {
        list.add(Lottery().init())
    }

    return list
}

fun createWinningLottery(): Lottery = Lottery().init()

fun Collection<Lottery>.checkResult(winningLottery: Lottery): LotteryStatistics {
    val statistics = LotteryStatistics()

    for (lottery in this) {
        statistics.addResult(lottery.equalsCount(winningLottery))
    }
    return statistics
}