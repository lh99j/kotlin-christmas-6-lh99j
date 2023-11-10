package christmas.model

import christmas.util.Validator.validateOrderCount

class Order(private val menu: List<Map<Menu, Int>>) {
    init {
        validateOrderCount(menu)
    }

    fun getTotalPrice(): Int {
        return menu.flatMap { it.entries }
            .sumOf { (menu, count) ->
                menu.price * count
            }
    }

    fun getMenu(): List<Map<Menu, Int>> = menu
}