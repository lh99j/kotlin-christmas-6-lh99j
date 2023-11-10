package christmas.model.discount

import christmas.model.Menu
import christmas.model.Order
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GiftDiscountTest {
    private lateinit var giftDiscount: GiftDiscount

    @BeforeEach
    fun setUp() {
        val input = listOf(
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
        giftDiscount = GiftDiscount(Order(input))
    }

    @Test
    @DisplayName("할인 대상이라고 올바르게 반환되는지 테스트한다.")
    fun checkTargetTrueTest() {
        assertThat(giftDiscount.checkTarget()).isTrue
    }

    @Test
    @DisplayName("할인 대상이 아니라고 올바르게 반환되는지 테스트한다.")
    fun checkTargetTestFalseTest(){
        giftDiscount = GiftDiscount(Order(listOf(mapOf(Menu("양송이수프", 6_000) to 2))))
        assertThat(giftDiscount.checkTarget()).isFalse
    }

    @Test
    @DisplayName("할인 혜택 금액이 올바르게 반환되는지 테스트한다.")
    fun getPriceTest() {
        assertThat(giftDiscount.getPrice()).isEqualTo(25000)
    }
}