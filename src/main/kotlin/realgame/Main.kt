package realgame

fun main() {
    // 구입 금액
    val money = Money(15000)

    // 로또 구매
    val lotteries = LotteryMachine.createLotteries(money,
        intArrayOf(1,2,3,4,5,6),
        intArrayOf(7,8,9,10,11,12),
        intArrayOf(13,14,15,16,17,18),
        intArrayOf(19,20,21,22,23,24)
    )

    // 당첨 번호
    val winningLottery = LotteryMachine.createWinningLottery(lotteries)

    val statistics = lotteries.checkResult(winningLottery)
    statistics.showResult()
}