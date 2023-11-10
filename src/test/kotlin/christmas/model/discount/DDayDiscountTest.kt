package christmas.model.discount

import christmas.model.discount.DDayDiscount
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class DDayDiscountTest {
    @ParameterizedTest
    @DisplayName("입력된 날짜에 해당하는 할인 금액을 가져온다.")
    @CsvSource(value = ["1:1000", "3:1200", "21:3000", "25:3400", "26:0"], delimiter = ':')
    fun getPriceTest(input: Int, expected: Int) {
        val dDayDiscount = DDayDiscount(input)
        val discountPrice = dDayDiscount.getPrice()
        assertThat(discountPrice).isEqualTo(expected)
    }
}