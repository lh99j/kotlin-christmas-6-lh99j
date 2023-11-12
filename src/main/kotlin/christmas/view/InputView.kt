package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.util.validator.DateValidator.validateDateInteger
import christmas.util.validator.DateValidator.validateDateNotNull
import christmas.util.validator.DateValidator.validateDateRange
import christmas.util.validator.OrderValidator.validateOrderForm
import christmas.util.validator.OrderValidator.validateOrderNotNull

class InputView {
    private fun userInput(): String = Console.readLine()

    fun readDate(): Int {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
        val input = userInput()

        validateDateNotNull(input)
        validateDateInteger(input)
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