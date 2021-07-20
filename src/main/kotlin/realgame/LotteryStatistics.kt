package realgame

class LotteryStatistics {
    private var totalCount = 0
    private val resultMap: MutableMap<LotteryReward, Int> = mutableMapOf(
        LotteryReward.No5 to 0, LotteryReward.No4 to 0, LotteryReward.No3 to 0, LotteryReward.No1 to 0
    )

    fun addResult(correctCount: Int): LotteryStatistics {
        if (correctCount < Lottery.LOTTERY_MIN_NUMBER - 1 || correctCount > Lottery.LOTTERY_MAX_NUMBER)
            throw IllegalArgumentException("Lottery number should be in 1~6 (correctCount : ${correctCount})")

        totalCount++
        resultMap.keys
            .find { it == LotteryReward.findByCount(correctCount) }
            ?.let { resultMap[it] = resultMap[it]?.plus(1) ?: 0 }

        return this
    }

    fun showResult() {
        val totalWinningAmount = resultMap.totalWinningAmount()
        val totalPurchasedAmount = totalCount * 1000

        println("""
            5등 : ${resultMap[LotteryReward.No5]}(${LotteryReward.No5.prize})
            4등 : ${resultMap[LotteryReward.No4]}(${LotteryReward.No4.prize})
            3등 : ${resultMap[LotteryReward.No3]}(${LotteryReward.No3.prize})
            2등 : (현재 미구현)
            1등 : ${resultMap[LotteryReward.No1]}(${LotteryReward.No1.prize})
            
            총 구입금액 : ${totalPurchasedAmount}
            총 당첨금액 : ${totalWinningAmount}
            수익률 : ${totalWinningAmount.toDouble() / totalPurchasedAmount.toDouble() * 100}%
        """.trimIndent())
    }
}

fun MutableMap<LotteryReward, Int>.totalWinningAmount() =
    this.map { it.key.prize * it.value }.sum()
