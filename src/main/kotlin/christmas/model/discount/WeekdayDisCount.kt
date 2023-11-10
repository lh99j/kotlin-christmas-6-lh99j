package christmas.model.discount

import christmas.model.Calendar
import christmas.model.Order

class WeekdayDiscount(private val order: Order, private val day: Int) : Discount {
    override fun getPrice(): Int {
        val orderMenu = order.getMenu()
        return orderMenu[2].size * 2023
    }

    override fun checkTarget(): Boolean {
        val calendar = Calendar()
        return calendar.checkWeekday(day)
    }
}