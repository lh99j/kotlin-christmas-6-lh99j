package christmas.model.discount

import christmas.model.Calendar
import christmas.util.Constants.SPECIAL_DISCOUNT_PRICE

class SpecialDiscount(private val day: Int) : Discount {
    override fun getPrice(): Int = SPECIAL_DISCOUNT_PRICE

    override fun checkTarget(): Boolean {
        val calendar = Calendar()
        return calendar.checkSpecialDay(day)
    }
}