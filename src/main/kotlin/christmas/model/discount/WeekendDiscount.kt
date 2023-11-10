package christmas.model.discount

import christmas.model.Calendar
import christmas.model.Order

class WeekendDiscount(private val order: Order, private val day: Int) : Discount {
    override fun getPrice(): Int {
        val orderMenu = order.getMenu()
        val totalCount = orderMenu[1].entries.sumOf { it.value }
        return totalCount * 2023
    }

    override fun checkTarget(): Boolean {
        val calendar = Calendar()
        return calendar.checkWeekend(day)
    }
}