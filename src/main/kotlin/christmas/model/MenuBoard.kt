package christmas.model

class MenuBoard {
    private val foods: List<List<Menu>>

    init {
        val appetizer = listOf(
            Menu("양송이수프", 6_000),
            Menu("타파스", 5_500),
            Menu("시저샐러드", 8_000)
        )

        val mainFood = listOf(
            Menu("티본스테이크", 55_000),
            Menu("바비큐립", 54_000),
            Menu("해산물파스타", 35_000),
            Menu("크리스마스파스타", 25_000)
        )

        val dessert = listOf(
            Menu("초코케이크", 15_000),
            Menu("아이스크림", 5_000)
        )

        val drink = listOf(
            Menu("제로콜라", 3_000),
            Menu("레드와인", 60_000),
            Menu("샴페인", 25_000)
        )

        foods = listOf(appetizer, mainFood, dessert, drink)
    }

    fun validateMenu(name: String) {
        val validation = foods.any { category ->
            category.any { menu ->
                menu.name == name
            }
        }
        require(validation) { "error" }
    }

    fun validateOrder(order: MutableSet<Menu>) {
        require(order.size - foods[3].intersect(order).count() > 0) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
    }

    fun getMenuPrice(name: String): Int {
        return foods.flatten().find { menu -> menu.name == name }!!.price
    }
}