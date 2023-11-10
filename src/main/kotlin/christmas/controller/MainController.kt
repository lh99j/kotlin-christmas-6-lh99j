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
    }

    fun splitInputMenu(inputMenu: List<String>): Map<Menu, Int> {
        val result = mutableMapOf<Menu, Int>()

        inputMenu.forEach {
            val (name, count) = it.split("-")
            menuBoard.checkValidMenu(name)
            val price = menuBoard.getMenuPrice(name)
            result[Menu(name, price)] = count.toInt()
        }

        return result
    }
}