package christmas.util

import christmas.model.MenuBoard
import christmas.model.Order
import christmas.model.data.Menu
import christmas.model.data.OrderForm
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OrderGeneratorTest {
    private val orderGenerator = OrderGenerator()

    @Test
    @DisplayName("Order 가 잘 생성되는지 확인한다.")
    fun makeOrderTest() {
        val validatorOrder = orderGenerator.makeOrder(input()).getMenu()
        val resultOrder = Order(result()).getMenu()

        assertThat(validatorOrder).isEqualTo(resultOrder)
    }

    private fun input(): List<String> = listOf("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1")
    private fun result(): List<List<OrderForm>> {
        val input = listOf(
            listOf(),
            listOf(
                OrderForm(Menu("티본스테이크", 55_000), 1),
                OrderForm(Menu("바비큐립", 54_000), 1)
            ),
            listOf(
                OrderForm(Menu("초코케이크", 15_000), 2)
            ),
            listOf(
                OrderForm(Menu("제로콜라", 3_000), 1)
            )
        )
        return input
    }
}