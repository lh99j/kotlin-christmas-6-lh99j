package christmas.view

import christmas.model.Benefits
import christmas.model.Order

class OutputView {
    fun printGreetings() {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
    }

    fun printPreviewMessage(date: Int) {
        println("12월 ${date}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
        println()
    }

    fun printMenu(order: Order) {
        println("<주문 메뉴>")
        order.getMenu()
            .flatMap { it.entries }
            .forEach { (menu, amount) ->
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

    fun printGift(order: Order) {
        val price = order.getTotalPrice()
        println("<증정 메뉴>")
        if (price >= 120_000) {
            println("샴페인 1개")
        } else {
            println("없음")
        }
        println()
    }

    fun printBenefits(benefits: Benefits) {
        println("<혜택 내역>")
        benefits.history.forEach { (type, price) ->
            println("${type}: ${price.format()}")
        }
        if (benefits.history.isEmpty()) {
            println("없음")
        }
        println()
    }

    fun printTotalBenefits(benefits: Benefits) {
        println("<총혜택 금액>")
        val totalBenefits = benefits.getTotalBenefit()
        println(if (totalBenefits > 0) totalBenefits.format() else "0원")
        println()
    }

    private fun Int.format(): String = String.format("%,d", this)
}