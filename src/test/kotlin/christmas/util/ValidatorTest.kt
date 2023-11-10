package christmas.util

import christmas.model.Menu
import christmas.util.Validator.validateDateRange
import christmas.util.Validator.validateInteger
import christmas.util.Validator.validateMenuName
import christmas.util.Validator.validateNotNull
import christmas.util.Validator.validateOrderCount
import christmas.util.Validator.validateOrderForm
import christmas.util.Validator.validateOrderNotNull
import christmas.util.Validator.validateUniqueOrder
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {
    @ParameterizedTest
    @DisplayName("공백이나 널값을 입력하면 예외가 발생한다.")
    @ValueSource(strings = ["", " ", "   "])
    fun validateNotNullTest(input: String) {
        assertThrows<IllegalArgumentException> {
            validateNotNull(input)
        }
    }

    @ParameterizedTest
    @DisplayName("정수가 아닌 값이 들어오면 예외가 발생한다.")
    @ValueSource(strings = ["abc", "12#", "!@#"])
    fun validateIntegerTest(input: String) {
        assertThrows<IllegalArgumentException> {
            validateInteger(input)
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

    @ParameterizedTest
    @DisplayName("리스트에 공백 또는 널값이 있다면 예외가 발생한다.")
    @ValueSource(strings = [",1", "1, ", "1,", ""])
    fun validateOrderNotNullTest(input: String) {
        assertThrows<IllegalArgumentException> {
            val splitInput = input.split(",")
            validateOrderNotNull(splitInput)
        }
    }

    @ParameterizedTest
    @DisplayName("리스트에 중복이 있다면 예외가 발생한다.")
    @CsvSource(value = ["abc,abc,d", "1,1,3", "lh99j,5,lh99j"], delimiter = ',')
    fun validateUniqueOrderTest(input1: String, input2: String, input3: String) {
        assertThrows<IllegalArgumentException> {
            validateUniqueOrder(listOf(input1, input2, input3))
        }
    }

    @ParameterizedTest
    @DisplayName("입력이 올바른 형식의 입력이 아니면 예외가 발생한다.")
    @ValueSource(strings = ["abc-", "-1", "abc- 1", "abac - 1", "abc -1", "abc", "-a"])
    fun validateOrderFormTest(input: String) {
        assertThrows<IllegalArgumentException> {
            val splitInput = input.split("-")
            validateOrderForm(splitInput)
        }
    }

    @Test
    @DisplayName("주문 합계가 20이 넘어가면 예외가 발생한다.")
    fun validateOrderCountTest(){
        val input = listOf(mapOf(Menu("티본스테이크", 55_000) to 21))
        assertThrows<IllegalArgumentException> {
            validateOrderCount(input)
        }
    }

    @Test
    @DisplayName("메뉴판에 없는 메뉴가 입력되면 예외가 발생한다.")
    fun validateMenuNameTest(){
        val input = listOf(listOf(Menu("티본스테이크", 55_000)))
        assertThrows<IllegalArgumentException> {
            validateMenuName(input, "초밥")
        }
    }
}