package christmas.util

import christmas.model.data.Menu
import christmas.model.data.OrderForm
import christmas.util.Constants.COUNT_INDEX
import christmas.util.Constants.DRINK_INDEX
import christmas.util.Constants.MAX_DATE
import christmas.util.Constants.MAX_ORDER_COUNT
import christmas.util.Constants.MIN_DATE
import christmas.util.Constants.SPLIT_SIZE

object Validator {
    private const val INVALID_DATE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."
    private const val INVALID_ORDER = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."

    fun validateNotNull(input: String) =
        require(input.trim().isNotEmpty()) { INVALID_DATE }

    fun validateInteger(input: String) =
        require(input.toIntOrNull() != null) { INVALID_DATE }

    fun validateDateRange(input: String) =
        require(input.toInt() in MIN_DATE..MAX_DATE) { INVALID_DATE }

    fun validateOrderNotNull(input: List<String>) =
        require(input.all { it.trim().isNotEmpty() }) { INVALID_ORDER }

    fun validateOrderForm(input: List<String>) {
        input.forEach {
            val splitInput = it.split("-")
            require(splitInput.size == SPLIT_SIZE) { INVALID_ORDER }
            require(splitInput[COUNT_INDEX].toIntOrNull() != null) { INVALID_ORDER }
        }
    }

    fun validateOrderCount(input: List<List<OrderForm>>) {
        require(input.flatten().sumOf { it.count } <= MAX_ORDER_COUNT) { INVALID_ORDER }
    }

    fun validateMenuName(foods: List<List<Menu>>, input: String) {
        val validation = foods.any { category ->
            category.any { menu ->
                menu.name == input
            }
        }
        require(validation) { INVALID_ORDER }
    }

    fun validateNotOnlyDrink(menu: List<List<OrderForm>>) {
        require(menu.flatten().size != menu[DRINK_INDEX].size) { INVALID_ORDER }
    }

    fun validateUniqueOrder(menu: List<List<OrderForm>>) {
        require(
            menu.flatten().distinctBy { it.menu.name }.size == menu.flatten().size
        ) { INVALID_ORDER }
    }
}