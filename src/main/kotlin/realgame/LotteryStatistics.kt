package realgame

import java.lang.IllegalArgumentException

class LotteryStatistics {
    private var accumulatedCount = 0
    private var accumulatedWinningAmount = 0
    private var no5 = 0
    private var no4 = 0
    private var no3 = 0
    private var no2 = 0
    private var no1 = 0

    fun addResult(correctCount: Int): LotteryStatistics {
        if (correctCount < 0 || correctCount > 6)
            throw IllegalArgumentException("Lottery number should be in 1~6")

        accumulatedCount++
        when (correctCount) {
            3 -> {
                no5++
                accumulatedWinningAmount+= 5000
            }
            4 -> {
                no4++
                accumulatedWinningAmount+= 50000
            }
            5 -> {
                no3++
                accumulatedWinningAmount+= 1000000
            }
            6 -> {
                no1++
                accumulatedWinningAmount+= 1000000000
            }
        }

        return this
    }

    fun showResult() {
        println("""
            5등 : ${no5}
            4등 : ${no4}
            3등 : ${no3}
            2등 : (현재 미구현)
            1등 : ${no1}
            
            총 수익률 : ${(accumulatedWinningAmount.toDouble() / (accumulatedCount * 1000).toDouble()) * 100}%
        """.trimIndent())
    }
}