package christmas.model

import christmas.util.Validator.validateOrder
import christmas.util.Validator.validateOrderCount

class Order(private val menu: List<List<OrderForm>>) {
    init {
//        validateOrderCount(menu)
//        validateOrder(menu)
    }

    fun getTotalPrice(): Int {
        return menu.flatten().sumOf { (menu, count) ->
            menu.price * count
        }
    }

    fun getMenu(): List<List<OrderForm>> = menu
}