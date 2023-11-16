package christmas.model.discount

class DDayDiscount(private val dDay: Int) : Discount {
    override fun getPrice(): Int {
        val discountPrice = (dDay - BASE_DATE) * INCREASE_PRICE + START_DISCOUNT_PRICE
        return discountPrice
    }

    override fun checkTarget(): Boolean = dDay < EVENT_END_DAY

    companion object {
        private const val START_DISCOUNT_PRICE = 1_000
        private const val EVENT_END_DAY = 26
        private const val INCREASE_PRICE = 100
        private const val BASE_DATE = 1
    }
}