package christmas.util

import christmas.model.MenuBoard
import christmas.model.Order
import christmas.model.data.Menu
import christmas.model.data.OrderForm

class OrderGenerator() {
    private val menuBoard = MenuBoard()

    fun makeOrder(inputMenu: List<String>): Order {
        val result: MutableList<MutableList<OrderForm>> =
            MutableList(FOOD_CATEGORY_SIZE) { mutableListOf() }

        inputMenu.forEach {
            val (name, count) = it.split("-")
            menuBoard.validateMenu(name)
            val price = menuBoard.getMenuPrice(name)
            val category = menuBoard.getFoodCategory(name)
            result[category].add(makeOrderForm(name, price, count.toInt()))
        }

        return Order(result)
    }

    private fun makeOrderForm(name: String, price: Int, count: Int): OrderForm =
        OrderForm(Menu(name, price), count)


    companion object {
        const val FOOD_CATEGORY_SIZE = 4
    }
}