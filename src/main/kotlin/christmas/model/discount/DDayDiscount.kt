package christmas.model.discount

import christmas.util.Constants.EVENT_END_DAY
import christmas.util.Constants.INCREASE_PRICE
import christmas.util.Constants.START_DISCOUNT_PRICE

class DDayDiscount(private val dDay: Int) : Discount {
    override fun getPrice(): Int {
        val discountPrice = (dDay - 1) * INCREASE_PRICE + START_DISCOUNT_PRICE
        return discountPrice
    }

    override fun checkTarget(): Boolean = dDay < EVENT_END_DAY
}