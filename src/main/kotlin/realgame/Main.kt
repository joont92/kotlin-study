package realgame

fun main() {
    // 구입 금액
    val money = Money(15000)

    // 로또 구매
    val lotteries = createLotteries(money)
    for (lottery in lotteries) {
        println("자동 : ${lottery}")
    }

    // 당첨 번호
    val winningLottery = createWinningLottery()
    println("당첨번호 : ${winningLottery}")

    val statistics = lotteries.checkResult(winningLottery)
    statistics.showResult()
}