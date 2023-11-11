package christmas.model

import christmas.util.Validator.validateNotOnlyDrink
import christmas.util.Validator.validateOrderCount
import christmas.util.Validator.validateUniqueOrder

class Order(private val menu: List<List<OrderForm>>) {
    init {
        validateOrderCount(menu)
        validateNotOnlyDrink(menu)
        validateUniqueOrder(menu)
    }

    fun getTotalPrice(): Int {
        return menu.flatten().sumOf { (menu, count) ->
            menu.price * count
        }
    }

    fun getMenu(): List<List<OrderForm>> = menu
}