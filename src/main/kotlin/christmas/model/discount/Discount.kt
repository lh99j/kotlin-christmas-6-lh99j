package christmas.model.discount

interface Discount {
    fun getPrice(): Int
    fun checkTarget(): Boolean
}