package christmas.model.discount

import christmas.model.Order

class GiftDiscount(private val order: Order) : Discount {
    override fun getPrice(): Int = GIFT_DISCOUNT_PRICE

    override fun checkTarget(): Boolean = order.getTotalPrice() >= DISCOUNT_STANDARD_PRICE

    companion object {
        private const val GIFT_DISCOUNT_PRICE = 25_000
        private const val DISCOUNT_STANDARD_PRICE = 120_000
    }
}