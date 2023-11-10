package christmas.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OrderTest {
    private val order = Order()

    @BeforeEach
    fun setUp() {
        order.addMenu(Menu("티본스테이크", 55_000))
        order.addMenu(Menu("해산물파스타", 35_000))
    }

    @Test
    @DisplayName("주문 가격의 총 금액을 잘 가져왔는지 확인한다.")
    fun getTotalPriceTest() {
        assertThat(order.getTotalPrice()).isEqualTo(90000)
    }

    @Test
    @DisplayName("주문한 음식이 잘 추가됐는지 확인한다.")
    fun addMenuTest() {
        order.addMenu(Menu("타파스", 5_500))

        assertThat(order.menu).hasSize(3)
            .contains(Menu("타파스", 5_500))
    }
}