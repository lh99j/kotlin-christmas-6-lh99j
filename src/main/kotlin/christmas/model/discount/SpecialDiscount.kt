package christmas.model.discount

import christmas.model.Calendar

class SpecialDiscount(private val day: Int) : Discount {
    override fun getPrice(): Int = SPECIAL_DISCOUNT_PRICE

    override fun checkTarget(): Boolean {
        val calendar = Calendar()
        return calendar.checkSpecialDay(day)
    }

    companion object {
        private const val SPECIAL_DISCOUNT_PRICE = 1_000
    }
}