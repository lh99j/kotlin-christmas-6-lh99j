package christmas.model

enum class Badge(private val type: String, private val price: Int) {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NOTHING("없음", 0);

    companion object {
        fun getType(price: Int): String = values().first { price >= it.price }.type
    }
}