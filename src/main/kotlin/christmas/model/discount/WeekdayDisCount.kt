package christmas.model.discount

import christmas.model.Calendar
import christmas.model.Order

class WeekdayDisCount(private val order: Order, private val day: Int) : Discount {
    override fun getPrice(): Int {
        TODO("Not yet implemented")
    }

    override fun checkTarget(): Boolean {
        val calendar = Calendar()
        return calendar.checkWeekday(day)
    }
}