package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.util.Validator.validateDateRange
import christmas.util.Validator.validateInteger
import christmas.util.Validator.validateNotNull
import christmas.util.Validator.validateOrderForm
import christmas.util.Validator.validateOrderNotNull
import christmas.util.Validator.validateUniqueOrder

class InputView {
    private fun userInput(): String = Console.readLine()

    fun readDate(): Int {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
        val input = userInput()

        validateNotNull(input)
        validateInteger(input)
        validateDateRange(input)

        return input.toInt()
    }

    fun readOrder(): List<String> {
        println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
        val input = userInput().split(",")

        validateOrderNotNull(input)
        validateOrderForm(input)

        return input
    }

}