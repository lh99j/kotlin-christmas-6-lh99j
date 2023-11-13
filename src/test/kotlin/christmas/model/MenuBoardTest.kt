package christmas.model

import christmas.util.Constants.APPETIZER_INDEX
import christmas.util.Constants.DESSERT_INDEX
import christmas.util.Constants.DRINK_INDEX
import christmas.util.Constants.MAIN_FOOD_INDEX
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class MenuBoardTest {
    private val menuBoard = MenuBoard()

    @ParameterizedTest
    @DisplayName("입력 메뉴가 메뉴판에 없으면 예외가 발생한다.")
    @ValueSource(strings = ["바나나우유, 초콜릿우유, 초밥"])
    fun checkValidMenuTest(input: String) {
        assertThrows<IllegalArgumentException> {
            menuBoard.validateMenu(input)
        }
    }

    @ParameterizedTest
    @DisplayName("입력 메뉴의 가격을 가져온다.")
    @CsvSource(
        value = ["양송이수프:6_000", "해산물파스타:35_000", "샴페인:25_000", "초코케이크:15_000"],
        delimiter = ':'
    )
    fun getMenuPriceTest(input: String, expected: Int) {
        assertThat(menuBoard.getMenuPrice(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @DisplayName("입력 메뉴의 카테고리를 가져온다.")
    @CsvSource(
        value = ["양송이수프:$APPETIZER_INDEX", "해산물파스타:$MAIN_FOOD_INDEX", "샴페인:$DRINK_INDEX", "초코케이크:$DESSERT_INDEX"],
        delimiter = ':'
    )
    fun getFoodCategoryTest(input: String, expected: Int) {
        assertThat(menuBoard.getFoodCategory(input)).isEqualTo(expected)
    }
}