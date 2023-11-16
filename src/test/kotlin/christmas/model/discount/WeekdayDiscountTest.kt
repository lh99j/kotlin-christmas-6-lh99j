package christmas.model.discount

import christmas.model.data.Menu
import christmas.model.Order
import christmas.model.data.OrderForm
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WeekdayDiscountTest {
    private lateinit var weekdayDiscount: WeekdayDiscount
    private lateinit var input: List<List<OrderForm>>

    @BeforeEach
    fun setUp() {
        input = listOf(
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
    }

    @ParameterizedTest
    @DisplayName("평일 할인 대상이 올바르게 반환되는지 테스트한다.")
    @CsvSource(value = ["2:false", "3:true", "9:false", "10:true"], delimiter = ':')
    fun checkTargetTest(inputDay: Int, expected: Boolean) {
        weekdayDiscount = WeekdayDiscount(Order(input), inputDay)
        assertThat(weekdayDiscount.checkTarget()).isEqualTo(expected)
    }

    @Test
    @DisplayName("총 할인 금액이 올바르게 반환되는지 테스트한다.")
    fun getPrice() {
        weekdayDiscount = WeekdayDiscount(Order(input), 3)
        assertThat(weekdayDiscount.getPrice()).isEqualTo(6069)
    }

}