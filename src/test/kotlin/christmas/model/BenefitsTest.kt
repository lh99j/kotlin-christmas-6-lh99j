package christmas.model

import christmas.model.Benefits
import christmas.util.Constants.DDAY_DISCOUNT
import christmas.util.Constants.GIFT_DISCOUNT
import christmas.util.Constants.SPECIAL_DISCOUNT
import christmas.util.Constants.WEEKDAY_DISCOUNT
import christmas.util.Constants.WEEKEND_DISCOUNT
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BenefitsTest {
    private val benefits = Benefits()

    @ParameterizedTest
    @DisplayName("할인 혜택이 잘 들어갔는지 확인한다.")
    @CsvSource(value = ["$DDAY_DISCOUNT,25000", "$WEEKDAY_DISCOUNT,1000"], delimiter = ',')
    fun addHistoryTest(type: String, price: Int) {
        benefits.addHistory(type, price)
        assertThat(benefits.history).hasSize(1)
            .containsKey(type)
            .containsValue(price)
    }

    @ParameterizedTest
    @DisplayName("할인 혜택을 잘 가져오는지 확인한다.")
    @CsvSource(
        value = ["$DDAY_DISCOUNT,25000,$WEEKDAY_DISCOUNT,1000,26000",
            "$WEEKEND_DISCOUNT,10000,$SPECIAL_DISCOUNT,1000,11000"], delimiter = ','
    )
    fun getTotalBenefitTest(type1: String, price1: Int, type2: String, price2: Int, expected: Int) {
        benefits.addHistory(type1, price1)
        benefits.addHistory(type2, price2)
        assertThat(benefits.getTotalBenefit()).isEqualTo(expected)
    }

    @ParameterizedTest
    @DisplayName("증정 할인을 뺀 금액을 잘 가져오는지 확인한다.")
    @CsvSource(
        value = ["$DDAY_DISCOUNT,200_000,$GIFT_DISCOUNT,25_000,175_000",
            "$WEEKEND_DISCOUNT,120_000,$GIFT_DISCOUNT,25_000,95_000"], delimiter = ','
    )
    fun getTotalDiscountTest(type1: String, price1: Int, type2: String, price2: Int, expected: Int) {
        benefits.addHistory(type1, price1)
        benefits.addHistory(type2, price2)
        assertThat(benefits.getTotalDiscount()).isEqualTo(expected)
    }
}