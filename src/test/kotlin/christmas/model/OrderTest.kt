package christmas.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OrderTest {
    @Test
    @DisplayName("주문 가격의 총 금액을 잘 가져왔는지 확인한다.")
    fun getTotalPriceTest() {
        val input = mapOf(
            Menu("초코케이크", 15_000) to 2,
            Menu("시저샐러드", 8_000) to 1
        )
        val order = Order(input)

        assertThat(order.getTotalPrice()).isEqualTo(38000)
    }
}