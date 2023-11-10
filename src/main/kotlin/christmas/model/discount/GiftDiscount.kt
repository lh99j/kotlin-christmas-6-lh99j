package christmas.model.discount

import christmas.model.Order

class GiftDiscount(private val order: Order) : Discount {
    override fun getPrice(): Int = 25000

    override fun checkTarget(): Boolean = order.getTotalPrice() > 120000
}