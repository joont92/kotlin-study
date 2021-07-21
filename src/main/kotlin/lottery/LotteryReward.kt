package lottery

enum class LotteryReward(private val count: Int, val prize: Long) {
    No5(3, 5_000), No4(4, 50_000), No3(5, 3_000_000), No1(6, 1_000_000_000);

    companion object {
        fun findByCount(count: Int): LotteryReward? =
            values().find { it.count == count }
    }
}