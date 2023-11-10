package christmas.view

import christmas.model.Order

class OutputView {
    fun printGreetings() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
    }

    fun printPreviewMessage() {
        println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
        println()
    }

    fun printMenu(order: Order) {
        println("<주문 메뉴>")
        val menu = order.getMenu()
        menu.forEach { (menu, amount) ->
            println("${menu.name} ${amount}개")
        }
        println()
    }

    fun printTotalPrice(order: Order) {
        val price = String.format("%,d원", order.getTotalPrice())
        println("<할인 전 총주문 금액>")
        println(price)
        println()
    }
}