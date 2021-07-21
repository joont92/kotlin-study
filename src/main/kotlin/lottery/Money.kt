package lottery

class Money(amount: Int) {
    var value = amount
        get() = field - field % 1000

    infix fun divide(unit: Int): Int = this.value / unit
}