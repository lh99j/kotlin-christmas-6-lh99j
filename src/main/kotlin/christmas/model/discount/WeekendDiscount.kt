package christmas.model.discount

import christmas.model.Calendar
import christmas.model.Order
import christmas.util.Constants.DISCOUNT_PRICE
import christmas.util.Constants.MAIN_FOOD_INDEX

class WeekendDiscount(private val order: Order, private val day: Int) : Discount {
    override fun getPrice(): Int {
        val orderMenu = order.getMenu()
        val totalCount = orderMenu[MAIN_FOOD_INDEX].entries.sumOf { it.value }
        return totalCount * DISCOUNT_PRICE
    }

    override fun checkTarget(): Boolean {
        val calendar = Calendar()
        return calendar.checkWeekend(day)
    }
}