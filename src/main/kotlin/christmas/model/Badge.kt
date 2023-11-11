package christmas.model

class Badge {
    private val type = listOf("없음", "별", "트리", "산타")

    fun getType(price: Int): String {
        return when {
            price >= 20000 -> type[3]
            price >= 10000 -> type[2]
            price >= 5000 -> type[1]
            else -> type[0]
        }
    }
}