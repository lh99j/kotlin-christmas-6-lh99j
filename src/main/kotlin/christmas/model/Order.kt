package christmas.model

class Order(private val menu: List<Map<Menu, Int>>) {
    init {
        require(menu.flatMap { it.values }.sum() <= 20) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
    }

    fun getTotalPrice(): Int {
        return menu.flatMap { it.entries }
            .sumOf { (menu, count) ->
                menu.price * count
            }
    }

    fun getMenu(): List<Map<Menu, Int>> = menu
}