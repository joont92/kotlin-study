package realgame

class RandomNumberGenerator(private val min: Int, private val max: Int): NumberGenerator {
    constructor(_max: Int): this(0, _max)

    override fun generateNumber() = (min..max).random()
}