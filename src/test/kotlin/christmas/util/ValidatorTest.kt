package christmas.util

import christmas.model.data.Menu
import christmas.model.Order
import christmas.model.data.OrderForm
import christmas.util.Validator.validateDateRange
import christmas.util.Validator.validateInteger
import christmas.util.Validator.validateMenuName
import christmas.util.Validator.validateNotNull
import christmas.util.Validator.validateOrderCount
import christmas.util.Validator.validateOrderForm
import christmas.util.Validator.validateOrderNotNull
import christmas.util.Validator.validateUniqueOrder
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {
    private lateinit var order: Order

    @BeforeEach
    fun setUp() {
        val input = listOf(
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
        order = Order(input)
    }

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

    @Test
    @DisplayName("리스트에 중복이 있다면 예외가 발생한다.")
    fun validateUniqueOrderTest() {
        assertThrows<IllegalArgumentException> {
            makeDuplicateOrder()
            validateUniqueOrder(order.getMenu())
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
    fun validateOrderCountTest() {
        assertThrows<IllegalArgumentException> {
            makeMaxCountOver()
            validateOrderCount(order.getMenu())
        }
    }

    @Test
    @DisplayName("메뉴판에 없는 메뉴가 입력되면 예외가 발생한다.")
    fun validateMenuNameTest() {
        val input = listOf(listOf(Menu("티본스테이크", 55_000)))
        assertThrows<IllegalArgumentException> {
            validateMenuName(input, "초밥")
        }
    }

    fun makeDuplicateOrder() {
        val input = listOf(
            listOf(),
            listOf(),
            listOf(
                OrderForm(Menu("시저샐러드", 8_000), 1),
                OrderForm(Menu("시저샐러드", 8_000), 2)
            ),
            listOf()
        )
        order = Order(input)
    }

    fun makeMaxCountOver() {
        val input = listOf(
            listOf(
                OrderForm(Menu("시저샐러드", 8_000), 21)
            )
        )
        order = Order(input)
    }
}