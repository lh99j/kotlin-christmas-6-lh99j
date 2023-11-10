package christmas

import christmas.controller.MainController
import christmas.view.InputView
import christmas.view.OutputView

fun main() {
    val mainController = MainController(InputView(), OutputView())
    mainController.run()
}
