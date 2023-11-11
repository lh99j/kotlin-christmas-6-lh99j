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
            .flatten()
            .forEach { (menu, count) ->
                println("${menu.name} ${count}개")
            }
        println()
    }

    fun printTotalPrice(order: Order) {
        val price = order.getTotalPrice()
        println("<할인 전 총주문 금액>")
        println(price.formatWithoutSign())
        println()
    }

    fun printGift(order: Order) {
        val price = order.getTotalPrice()
        println("<증정 메뉴>")
        println(if (price >= 120_000) "샴페인 1개" else "없음")
        println()
    }

    fun printBenefits(benefits: Benefits) {
        println("<혜택 내역>")
        if (benefits.history.isEmpty()) {
            println("없음")
        }
        benefits.history.forEach { (type, price) ->
            println("${type}: ${price.formatWithSign()}")
        }
        println()
    }

    fun printTotalBenefits(benefits: Benefits) {
        println("<총혜택 금액>")
        val totalBenefits = benefits.getTotalBenefit()
        println(if (totalBenefits > 0) totalBenefits.formatWithSign() else "0원")
        println()
    }

    fun printPriceAfterDiscount(price: Int) {
        println("<할인 후 예상 결제 금액>")
        println(price.formatWithoutSign())
        println()
    }

    fun printBadgeType(type: String) {
        println("<12월 이벤트 배지>")
        println(type)
    }

    private fun Int.formatWithSign(): String = String.format("-%,d원", this)
    private fun Int.formatWithoutSign(): String = String.format("%,d원", this)

}