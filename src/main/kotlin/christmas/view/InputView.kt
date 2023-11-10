package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.model.Menu

class InputView {
    fun userInput(): String = Console.readLine()

    fun readDate(): Int {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
        val input = userInput()
        require(input.trim().isNotEmpty()) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }
        require(input.toIntOrNull() != null) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }
        require(input.toInt() in 1..31) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }
        return input.toInt()
    }

    fun readOrder(): List<String> {
        println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
        val input = userInput()
        val splitInput = input.split(",")

        require(splitInput.all { it.trim().isNotEmpty() })
        require(splitInput.toSet().size == splitInput.size) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }

        splitInput.forEach {
            val splitMenu = it.split("-")
            require(splitMenu.size == 2) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
            require(splitMenu[1].toIntOrNull() != null) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
        }

        return splitInput
    }

}