package christmas.model

class Calendar {
    private val weekend = listOf(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)
    private val specialDay = listOf(3, 10, 17, 24, 25, 31)

    fun checkWeekend(day: Int): Boolean = weekend.contains(day)
    fun checkSpecialDay(day: Int): Boolean = specialDay.contains(day)
}