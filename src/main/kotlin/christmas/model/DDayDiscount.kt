package christmas.model

class DDayDiscount {
    fun getPrice(day: Int): Int {
        if (day <= 25) {
            val discountPrice = (day - 1) * 100 + 1000
            return discountPrice
        }
        return 0
    }
}