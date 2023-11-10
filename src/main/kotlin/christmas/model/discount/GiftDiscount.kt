package christmas.model.discount

import christmas.model.Order
import christmas.util.Constants.DISCOUNT_STANDARD_PRICE
import christmas.util.Constants.GIFT_DISCOUNT_PRICE

class GiftDiscount(private val order: Order) : Discount {
    override fun getPrice(): Int = GIFT_DISCOUNT_PRICE

    override fun checkTarget(): Boolean = order.getTotalPrice() >= DISCOUNT_STANDARD_PRICE
}