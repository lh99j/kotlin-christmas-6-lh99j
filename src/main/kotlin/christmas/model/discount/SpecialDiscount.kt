package christmas.model.discount

import christmas.model.Calendar

class SpecialDiscount(private val day: Int) : Discount {
    override fun getPrice(): Int {
        TODO("Not yet implemented")
    }

    override fun checkTarget(): Boolean {
        val calendar = Calendar()
        return calendar.checkSpecialDay(day)
    }
}