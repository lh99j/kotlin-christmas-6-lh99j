package christmas.view

import christmas.model.Benefits
import christmas.model.Order

class OutputView {
    fun printGreetings() =
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")


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
        println(if (price >= GIFT_PRICE) GIFT else NOT_BENEFIT)
        println()
    }

    fun printBenefits(benefits: Benefits) {
        println("<혜택 내역>")
        if (benefits.history.isEmpty()) {
            println(NOT_BENEFIT)
        }
        benefits.history.forEach { (type, price) ->
            println("${type}: ${price.formatWithSign()}")
        }
        println()
    }

    fun printTotalBenefits(benefits: Benefits) {
        println("<총혜택 금액>")
        val totalBenefits = benefits.getTotalBenefit()
        println(if (totalBenefits > ZERO_PRICE) totalBenefits.formatWithSign() else NOT_DISCOUNT)
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

    companion object {
        const val ZERO_PRICE = 0
        const val GIFT_PRICE = 120_000
        const val NOT_DISCOUNT = "0원"
        const val NOT_BENEFIT = "없음"
        const val GIFT = "샴페인 1개"
    }
}