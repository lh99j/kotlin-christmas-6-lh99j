package christmas.util

import christmas.model.Menu
import christmas.model.OrderForm
import christmas.util.Constants.COUNT_INDEX
import christmas.util.Constants.DRINK_INDEX
import christmas.util.Constants.MAX_DATE
import christmas.util.Constants.MAX_ORDER_COUNT
import christmas.util.Constants.MIN_DATE
import christmas.util.Constants.SPLIT_SIZE

object Validator {
    fun validateNotNull(input: String) =
        require(input.trim().isNotEmpty()) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }

    fun validateInteger(input: String) =
        require(input.toIntOrNull() != null) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }

    fun validateDateRange(input: String) =
        require(input.toInt() in MIN_DATE..MAX_DATE) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }

    fun validateOrderNotNull(input: List<String>) =
        require(input.all { it.trim().isNotEmpty() }) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }

    fun validateOrderForm(input: List<String>) {
        input.forEach {
            val splitInput = it.split("-")
            require(splitInput.size == SPLIT_SIZE) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
            require(splitInput[COUNT_INDEX].toIntOrNull() != null) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
        }
    }

    fun validateOrderCount(input: List<List<OrderForm>>) {
        require(input.flatten().sumOf { it.count } <= MAX_ORDER_COUNT) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
    }

    fun validateMenuName(foods: List<List<Menu>>, input: String) {
        val validation = foods.any { category ->
            category.any { menu ->
                menu.name == input
            }
        }
        require(validation) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
    }

    fun validateNotOnlyDrink(menu: List<List<OrderForm>>) {
        require(menu.flatten().size != menu[DRINK_INDEX].size) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
    }

    fun validateUniqueOrder(menu: List<List<OrderForm>>) {
        require(
            menu.flatten().distinctBy { it.menu.name }.size == menu.flatten().size
        ) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
    }
}