package christmas.model.discount

import christmas.model.Calendar
import christmas.model.Order
import christmas.util.Constants.DESSERT_INDEX
import christmas.util.Constants.DISCOUNT_PRICE

class WeekdayDiscount(private val order: Order, private val day: Int) : Discount {
    override fun getPrice(): Int {
        val orderMenu = order.getMenu()
        val totalCount = orderMenu[DESSERT_INDEX].sumOf { it.count }
        return totalCount * DISCOUNT_PRICE
    }

    override fun checkTarget(): Boolean {
        val calendar = Calendar()
        return calendar.checkWeekday(day)
    }
}