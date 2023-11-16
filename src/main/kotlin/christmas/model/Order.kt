package christmas.model

import christmas.model.data.OrderForm
import christmas.util.validator.OrderValidator.validateNotOnlyDrink
import christmas.util.validator.OrderValidator.validateOrderCount
import christmas.util.validator.OrderValidator.validateUniqueOrder

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