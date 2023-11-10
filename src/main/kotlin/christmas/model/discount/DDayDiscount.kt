package christmas.model.discount

class DDayDiscount(private val dDay: Int) : Discount {
    override fun getPrice(): Int {
        if (dDay <= 25) {
            val discountPrice = (dDay - 1) * 100 + 1000
            return discountPrice
        }
        return 0
    }

    override fun checkTarget(): Boolean = dDay <= 25
}