package christmas.model

class DDayDiscount(private val dDay: Int) {
    fun getPrice(): Int {
        if (dDay <= 25) {
            val discountPrice = (dDay - 1) * 100 + 1000
            return discountPrice
        }
        return 0
    }
}