package christmas.model.discount

import christmas.model.Menu
import christmas.model.Order
import christmas.model.OrderForm
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GiftDiscountTest {
    private lateinit var giftDiscount: GiftDiscount

    @BeforeEach
    fun setUp() {
        val input = listOf(
            listOf(
                OrderForm(Menu("양송이수프", 6_000), 2),
                OrderForm(Menu("시저샐러드", 8_000), 1)
            ),
            listOf(
                OrderForm(Menu("티본스테이크", 55_000), 2),
                OrderForm(Menu("해산물파스타", 35_000), 2)
            ),
            listOf(
                OrderForm(Menu("아이스크림", 5_000), 2),
                OrderForm(Menu("초코케이크", 15_000), 1)
            ),
            listOf(
                OrderForm(Menu("샴페인", 25_000), 1)
            )
        )
        giftDiscount = GiftDiscount(Order(input))
    }

    @Test
    @DisplayName("할인 대상이라고 올바르게 반환되는지 테스트한다.")
    fun checkTargetTrueTest() {
        assertThat(giftDiscount.checkTarget()).isTrue
    }

    @Test
    @DisplayName("할인 대상이 아니라고 올바르게 반환되는지 테스트한다.")
    fun checkTargetTestFalseTest() {
        val order = makeOrder()
        giftDiscount = GiftDiscount(order)
        assertThat(giftDiscount.checkTarget()).isFalse
    }

    @Test
    @DisplayName("할인 혜택 금액이 올바르게 반환되는지 테스트한다.")
    fun getPriceTest() {
        assertThat(giftDiscount.getPrice()).isEqualTo(25000)
    }

    fun makeOrder(): Order {
        val input = listOf(
            listOf(),
            listOf(),
            listOf(
                OrderForm(Menu("시저샐러드", 8_000), 1)
            ),
            listOf()
        )
        return Order(input)
    }
}