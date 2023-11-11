package christmas.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OrderTest {
    @Test
    @DisplayName("주문 가격의 총 금액을 잘 가져왔는지 확인한다.")
    fun getTotalPriceTest() {
        val input = listOf(
            listOf(
                OrderForm(Menu("양송이수프", 6_000), 2),
                OrderForm(Menu("시저샐러드", 8_000), 1)
            ),
            listOf(
                OrderForm(Menu("해산물파스타", 35_000), 2)
            ),
            listOf(
                OrderForm(Menu("초코케이크", 15_000), 1)
            ),
            listOf(
                OrderForm(Menu("샴페인", 25_000), 1)
            )
        )
        val order = Order(input)

        assertThat(order.getTotalPrice()).isEqualTo(130_000)
    }
}