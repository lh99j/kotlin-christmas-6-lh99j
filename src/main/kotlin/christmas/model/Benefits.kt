package christmas.model

import christmas.util.Constants.GIFT_DISCOUNT

class Benefits {
    private var _history = mutableMapOf<String, Int>()
    val history: Map<String, Int>
        get() = _history

    fun addHistory(type: String, price: Int) {
        _history[type] = _history.getOrDefault(type, 0) + price
    }

    fun getTotalBenefit(): Int = _history.values.sum()

    fun getTotalDiscount(): Int =
        _history.values.sum() - _history.getOrDefault(GIFT_DISCOUNT, 0)
}