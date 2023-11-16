package christmas.model.discount

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class DDayDiscountTest {
    @ParameterizedTest
    @DisplayName("입력된 날짜에 해당하는 할인 금액을 가져온다.")
    @CsvSource(value = ["1:1000", "3:1200", "21:3000", "25:3400"], delimiter = ':')
    fun getPriceTest(input: Int, expected: Int) {
        val dDayDiscount = DDayDiscount(input)
        val discountPrice = dDayDiscount.getPrice()
        assertThat(discountPrice).isEqualTo(expected)
    }

    @ParameterizedTest
    @DisplayName("입력된 날짜가 디데이 할인을 받을 수 있는지 테스트한다.")
    @CsvSource(value = ["1:true", "3:true", "25:true", "26:false", "31:false"], delimiter = ':')
    fun checkTargetTest(input: Int, expected: Boolean) {
        val dDayDiscount = DDayDiscount(input)
        val checkTarget = dDayDiscount.checkTarget()
        assertThat(checkTarget).isEqualTo(expected)
    }

}