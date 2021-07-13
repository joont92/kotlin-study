package realgame

class Money(amount: Int) {
    var value = amount
        get() = field - field % 1000
}

infix fun Money.divide(unit: Int): Int = this.value / unit