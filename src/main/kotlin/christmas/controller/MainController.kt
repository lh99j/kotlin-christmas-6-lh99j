package christmas.controller

import christmas.model.Menu
import christmas.model.MenuBoard
import christmas.model.Order
import christmas.view.InputView
import christmas.view.OutputView

class MainController(private val inputView: InputView, private val outputView: OutputView) {
    private val menuBoard = MenuBoard()
    fun run() {
        outputView.printGreetings()
        val date = inputView.readDate()

        val inputMenu = inputView.readOrder()
        val orders = splitInputMenu(inputMenu)
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
}