package christmas.model.discount

import christmas.model.Order

class DayDisCount(private val order: Order, private val day: Int) : Discount {
    override fun getPrice(): Int {
        TODO("Not yet implemented")
    }
}