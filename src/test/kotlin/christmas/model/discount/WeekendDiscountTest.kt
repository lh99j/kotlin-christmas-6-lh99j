package christmas.model.discount

import christmas.model.Menu
import christmas.model.Order
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WeekendDiscountTest {
    private lateinit var weekendDiscount: WeekendDiscount
    private lateinit var input: List<Map<Menu, Int>>

    @BeforeEach
    fun setUp() {
        input = listOf(
            mapOf(
                Menu("양송이수프", 6_000) to 2
            ),
            mapOf(
                Menu("티본스테이크", 55_000) to 2,
                Menu("바비큐립", 54_000) to 3,
            ),
            mapOf(
                Menu("티본스테이크", 55_000) to 2,
                Menu("바비큐립", 54_000) to 3,
            ),
            mapOf(
                Menu("초코케이크", 15_000) to 1,
                Menu("아이스크림", 5_000) to 1
            ),
            mapOf(
                Menu("제로콜라", 3_000) to 1,
            )
        )
    }

    @ParameterizedTest
    @DisplayName("평일 할인 대상이 올바르게 반환되는지 테스트한다.")
    @CsvSource(value = ["2:true", "3:false", "9:true", "10:false"], delimiter = ':')
    fun checkTargetTest(inputDay: Int, expected: Boolean) {
        weekendDiscount = WeekendDiscount(Order(input), inputDay)
        Assertions.assertThat(weekendDiscount.checkTarget()).isEqualTo(expected)
    }

    @Test
    @DisplayName("총 할인 금액이 올바르게 반환되는지 테스트한다.")
    fun getPrice(){
        weekendDiscount = WeekendDiscount(Order(input), 3)
        Assertions.assertThat(weekendDiscount.getPrice()).isEqualTo(10115)
    }
}