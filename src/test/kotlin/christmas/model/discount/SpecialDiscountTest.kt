package christmas.model.discount

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SpecialDiscountTest {
    @ParameterizedTest
    @DisplayName("할인 대상이 올바르게 반환되는지 테스트한다.")
    @CsvSource(value = ["3:true", "4:false", "19:false"], delimiter = ':')
    fun checkTargetTest(input: Int, expected: Boolean) {
        val specialDiscount = SpecialDiscount(input)
        assertThat(specialDiscount.checkTarget()).isEqualTo(expected)
    }

    @Test
    @DisplayName("할인 금액이 올바르게 반환되는지 테스트한다.")
    fun getPriceTest() {
        val specialDiscount = SpecialDiscount(3)
        assertThat(specialDiscount.getPrice()).isEqualTo(1000)
    }
}