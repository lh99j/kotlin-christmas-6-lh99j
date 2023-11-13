package christmas.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class CalendarTest {
    private val calendar = Calendar()

    @ParameterizedTest
    @DisplayName("주어진 날짜가 주말이면 true, 아니면 false 를 반환한다.")
    @CsvSource(value = ["1:true", "14:false", "25:false", "30:true"], delimiter = ':')
    fun checkWeekendTest(input: Int, expected: Boolean) {
        assertThat(calendar.checkWeekend(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @DisplayName("주어진 날짜가 평일이면 true, 아니면 false 를 반환한다.")
    @CsvSource(value = ["1:false", "14:true", "25:true", "30:false"], delimiter = ':')
    fun checkWeekdayTest(input: Int, expected: Boolean) {
        assertThat(calendar.checkWeekday(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @DisplayName("주어진 날짜가 특별 할인 날짜면 true 를 반환한다.")
    @CsvSource(value = ["3:true", "17:true", "18:false", "25:true"], delimiter = ':')
    fun checkSpecialDayTest(input: Int, expected: Boolean) {
        assertThat(calendar.checkSpecialDay(input)).isEqualTo(expected)
    }
}