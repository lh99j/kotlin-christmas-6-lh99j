package christmas.controller

import christmas.model.Menu
import christmas.model.MenuBoard
import christmas.model.Order
import christmas.view.InputView
import christmas.view.OutputView
import java.lang.IllegalArgumentException

class MainController(private val inputView: InputView, private val outputView: OutputView) {
    private val menuBoard = MenuBoard()
    private lateinit var order: Order
    fun run() {
        val date = getDate()

        val orders = getOrderMenu()
        val order = Order(orders)

        outputView.printPreviewMessage()
        outputView.printMenu(order)
        outputView.printTotalPrice(order)
    }

    fun splitInputMenu(inputMenu: List<String>): List<Map<Menu, Int>> {
        val result: MutableList<MutableMap<Menu, Int>> = MutableList(4) { mutableMapOf() }

        inputMenu.forEach {
            val (name, count) = it.split("-")
            menuBoard.validateMenu(name)
            val price = menuBoard.getMenuPrice(name)
            val category = menuBoard.getFoodCategory(name)
            result[category][Menu(name, price)] = count.toInt()
        }

        return result
    }

    private fun getDate(): Int {
        outputView.printGreetings()
        while (true) {
            try {
                val input = inputView.readDate()
                return input
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getOrderMenu(): List<Map<Menu, Int>> {
        while (true) {
            try {
                val inputMenu = inputView.readOrder()
                val orders = splitInputMenu(inputMenu)
                return orders
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}