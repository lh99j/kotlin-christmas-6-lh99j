package christmas.model

class Order(private val menu: Map<Menu, Int>) {
    init {
        require(menu.entries.sumOf { it.value } < 20) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
    }

    fun getTotalPrice(): Int = menu.entries.sumOf { it.key.price * it.value }
}