package christmas.util.validator

object DateValidator {
    private const val INVALID_DATE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."
    private const val MIN_DATE = 1
    private const val MAX_DATE = 31

    fun validateDateNotNull(input: String) =
        require(input.trim().isNotEmpty()) { INVALID_DATE }

    fun validateDateInteger(input: String) =
        require(input.toIntOrNull() != null) { INVALID_DATE }

    fun validateDateRange(input: String) =
        require(input.toInt() in MIN_DATE..MAX_DATE) { INVALID_DATE }
}