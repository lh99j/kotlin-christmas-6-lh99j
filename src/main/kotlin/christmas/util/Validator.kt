package christmas.util

import christmas.model.Menu

object Validator {
    fun validateNotNull(input: String) =
        require(input.trim().isNotEmpty()) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }


    fun validateInteger(input: String) =
        require(input.toIntOrNull() != null) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }


    fun validateDateRange(input: String) =
        require(input.toInt() in 1..31) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }

    fun validateOrderNotNull(input: List<String>) =
        require(input.all { it.trim().isNotEmpty() }) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }

    fun validateUniqueOrder(input: List<String>) =
        require(input.toSet().size == input.size) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }

    fun validateOrderForm(input: List<String>) {
        input.forEach {
            val (name, count) = it.split("-")
            require(name.isNotEmpty() && count.isNotEmpty()) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
            require(count.toIntOrNull() != null) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
        }
    }

    fun validateOrderCount(input: List<Map<Menu, Int>>) {
        require(input.flatMap { it.values }.sum() <= 20) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
    }

    fun validateMenuName(foods: List<List<Menu>>, input: String) {
        val validation = foods.any { category ->
            category.any { menu ->
                menu.name == input
            }
        }
        require(validation) { "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." }
    }
}