package christmas.util

import christmas.util.validator.DateValidator.validateDateRange
import christmas.util.validator.DateValidator.validateDateInteger
import christmas.util.validator.DateValidator.validateDateNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DateValidatorTest {
    @ParameterizedTest
    @DisplayName("공백이나 널값을 입력하면 예외가 발생한다.")
    @ValueSource(strings = ["", " ", "   "])
    fun validateNotNullTest(input: String) {
        assertThrows<IllegalArgumentException> {
            validateDateNotNull(input)
        }
    }

    @ParameterizedTest
    @DisplayName("정수가 아닌 값이 들어오면 예외가 발생한다.")
    @ValueSource(strings = ["abc", "12#", "!@#"])
    fun validateIntegerTest(input: String) {
        assertThrows<IllegalArgumentException> {
            validateDateInteger(input)
        }
    }

    @ParameterizedTest
    @DisplayName("올바른 범위의 숫자가 아니면 예외가 발생한다.")
    @ValueSource(strings = ["-1", "32", "0"])
    fun validateDateRangeTest(input: String) {
        assertThrows<IllegalArgumentException> {
            validateDateRange(input)
        }
    }
}