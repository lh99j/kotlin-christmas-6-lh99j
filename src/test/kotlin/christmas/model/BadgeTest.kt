package christmas.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BadgeTest {
    private val badge = Badge()

    @ParameterizedTest
    @DisplayName("배지 타입을 잘 가져오는지 테스트한다.")
    @CsvSource(value = ["20000:산타", "10000:트리", "5000:별", "4900:없음"], delimiter = ':')
    fun getTypeTest(input: Int, expected: String) {
        assertThat(badge.getType(input)).isEqualTo(expected)
    }
}